package be.crydust;

public class TestCase {
    private final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void setUp() {
        // NOOP
    }

    public TestResult run() {
        TestResult result = new TestResult();
        result.testStarted();
        this.setUp();
        try {
            this.getClass()
                    .getDeclaredMethod(name)
                    .invoke(this);
        } catch (Exception e) {
            result.testFailed();
            e.printStackTrace();
        }
        this.tearDown();
        return result;
    }

    public void tearDown() {
        // NOOP
    }

}
