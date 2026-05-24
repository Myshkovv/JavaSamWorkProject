import java.lang.reflect.Method;

import java.lang.reflect.Method;

public class TestRunner {
    public static void runTests(Class<?> testClass) {
        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();

            for (Method method : testClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(FileTest.class)) {
                    try {
                        method.invoke(instance);
                        System.out.println(method.getName() + " - PASSED");
                    } catch (Exception e) {
                        // e.getCause() может быть null, добавили проверку на всякий случай
                        Throwable cause = e.getCause();
                        String msg = (cause != null) ? cause.getMessage() : e.getMessage();
                        System.err.println(method.getName() + " - FAILED: " + msg);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}