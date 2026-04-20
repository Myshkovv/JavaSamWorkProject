package tests;

import annotation.BeforeAll;
import annotation.GenerateEdgeClass;
import annotation.MathTest;
import annotation.MathUtils;

public class MyMathTest {
    @BeforeAll
    public void setup() {
        System.out.println("Подготовка тестовой среды...");
    }
    @MathTest
    public void testDevide(@GenerateEdgeClass int a, @GenerateEdgeClass int b){
        int result = MathUtils.divide(a, b);
    }

    public void testIsPrime(@GenerateEdgeClass int num){
        boolean result = MathUtils.isPrime(num);

        if (num == 67 && !result) throw new RuntimeException("67 is prime");
    }

}
