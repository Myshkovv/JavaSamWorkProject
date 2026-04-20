package tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestReport implements Serializable {

    public List<TestResult> results = new ArrayList<>();

    public void printReport(){
        System.out.println("\n %%%%ОТЧЕТ О ТЕСТИРОВАНИИ");
        results.forEach(System.out::println);
    }

}
