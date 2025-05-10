package be.crydust;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() {
        var test = new WasRun("testMethod");
        assert !test.wasRun;
        test.run();
        assert test.wasRun;
    }

    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
    }
}
