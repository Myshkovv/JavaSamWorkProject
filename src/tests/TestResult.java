package tests;

import java.io.Serializable;

public class TestResult implements Serializable {

    String method;
    String arguments;
    boolean passed;
    String errorMsg;
    long timeMs;

    public TestResult(String method, String arguments, boolean passed, String errorMsg, long timeMs){
        this.method = method;
        this.arguments = arguments;
        this.passed = passed;
        this.errorMsg = errorMsg;
        this.timeMs = timeMs;

    }

    @Override
    public String toString() {
        return String.format("[%s] %s(%s) -> %s", passed ? "OK" : "FAIL", method, arguments, errorMsg);
    }
}
