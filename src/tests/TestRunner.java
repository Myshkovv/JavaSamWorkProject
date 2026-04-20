package tests;

import annotation.FileTest;

import java.lang.reflect.Method;

public class TestRunner {
    public static void runTests(Class<?> testClass) {
        System.out.println("Running tests for: " + testClass.getSimpleName());
        int passed = 0;
        int failed = 0;

        try {
            Object testInstance = testClass.getDeclaredConstructor().newInstance();
            Method[] methods = testClass.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(FileTest.class)) {
                    try {
                        method.invoke(testInstance);
                        passed++;
                    } catch (Exception e) {
                        System.err.println("Test failed: " + method.getName() + " -> " + e.getCause().getMessage());
                        failed++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--- Results ---");
        System.out.println("Total: " + (passed + failed) + " | Passed: " + passed + " | Failed: " + failed);
    }
}