import annotation.BeforeAll;
import annotation.GenerateEdgeClass;
import annotation.MathTest;
import tests.TestReport;
import tests.TestResult;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathTester {

    private static final int[] EDGE_CASES = {0, 1, -1, Integer.MAX_VALUE, 67};

    public static void run(Class<?> testClass) throws Exception{
        Object instance = testClass.getDeclaredConstructor().newInstance();

        TestReport report =new TestReport();
        Method[] methods = testClass.getDeclaredMethods();

        for (Method m: methods){
            if (m.isAnnotationPresent(BeforeAll.class)){
                m.invoke(instance);
            }
        }

        for (Method m : methods){
            if (!m.isAnnotationPresent(MathTest.class)){
                continue;
            }

            Parameter[] params = m.getParameters();
            List<Object[]> argCombi = generatorCombi(params);

            for (Object[] args: argCombi){
                long start = System.currentTimeMillis();
                boolean passed = true;
                String error = "Success";

                try {
                    m.invoke(instance, args);
                } catch (InvocationTargetException e){
                    passed = false;
                    error = e.getCause().getClass().getSimpleName() + ": " + e.getCause().getMessage();
                } catch (Exception ex){
                    passed = false;
                    error = ex.getMessage();
                }

                long time = System.currentTimeMillis() - start;
                report.results.add(new TestResult(m.getName(), Arrays.toString(args), passed, error, time));
            }
        }

        report.printReport();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test_repor.ser"))) {
            oos.writeObject(report);
            System.out.println("\n[i] Отчет сохранен");
        }
    }

    private static List<Object[]> generatorCombi(Parameter[] params){
        List<Object[]> combi = new ArrayList<>();

        if (params.length == 0){
            combi.add(new Object[0]);
            return combi;
        }

        List<List<Object>> paramsValue = new ArrayList<>();

        for (Parameter p: params){
            List<Object> values = new ArrayList<>();

            if (p.isAnnotationPresent(GenerateEdgeClass.class) && p.getType() == int.class){
                for (int val: EDGE_CASES) {
                    values.add(val);
                }
            } else {
                values.add(0);
            }

            paramsValue.add(values);
        }

        buildCombi(paramsValue, 0, new Object[params.length], combi);
        return combi;
    }

    private static void buildCombi(List<List<Object>> lists, int depth, Object[] current, List<Object[]> results){
        if (depth == lists.size()){
            results.add(current.clone());
            return;
        }

        for (Object item: lists.get(depth)){
            current[depth] = item;
            buildCombi(lists, depth + 1, current, results);
        }
    }
}
