package be.crydust;

import static be.crydust.CustomAssertions.assertTrue;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String name) {
        super(name);
    }

    public void testRunning() {
        var test = new WasRun("testMethod");
        test.run();
        assertTrue(test.wasRun, "wasRun should be true after running the test");
    }

    public void testSetUp() {
        var test = new WasRun("testMethod");
        test.run();
        assertTrue(test.wasSetup, "wasSetup should be true after running the test");
    }

    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
