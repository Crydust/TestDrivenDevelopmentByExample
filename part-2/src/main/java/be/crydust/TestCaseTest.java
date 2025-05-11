package be.crydust;

import static be.crydust.CustomAssertions.assertTrue;

public class TestCaseTest extends TestCase {
    private WasRun test;

    public TestCaseTest(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        test = new WasRun("testMethod");
    }

    public void testRunning() {
        test.run();
        assertTrue(test.wasRun, "wasRun should be true after running the test");
    }

    public void testSetUp() {
        test.run();
        assertTrue(test.wasSetup, "wasSetup should be true after running the test");
    }

    public static void main(String[] args) {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
