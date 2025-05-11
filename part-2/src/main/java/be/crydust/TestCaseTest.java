package be.crydust;

import static be.crydust.CustomAssertions.assertEquals;

public class TestCaseTest extends TestCase {
    private WasRun test;

    public TestCaseTest(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        test = new WasRun("testMethod");
    }

    public void testTemplateMethod() {
        test.run();
        assertEquals("setUp testMethod tearDown ", test.log);
    }

    public void testResult() {
        TestResult result = test.run();
        assertEquals("1 run, 0 failed", result.summary());
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        TestResult result = test.run();
        assertEquals("1 run, 1 failed", result.summary());
    }

    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testResult").run();
        new TestCaseTest("testFailedResult").run();
    }
}
