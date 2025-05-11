package be.crydust;

import java.lang.reflect.InvocationTargetException;

public class TestCase {
    private final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void setUp() {
        // NOOP
    }

    public void run(TestResult result) {
        result.testStarted();
        setUp();
        try {
            getClass()
                    .getDeclaredMethod(name)
                    .invoke(this);
        } catch (Exception e) {
            result.testFailed();
            if (e instanceof InvocationTargetException ite) {
                ite.getCause().printStackTrace();
            } else {
                e.printStackTrace();
            }
        }
        tearDown();
    }

    public void tearDown() {
        // NOOP
    }

}
