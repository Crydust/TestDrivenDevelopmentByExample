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
        test.run(new TestResult());
        assertEquals("setUp testMethod tearDown ", test.log);
    }

    public void testResult() {
        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 0 failed", result.summary());
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        TestResult result = new TestResult();
        test.run(result);
        assertEquals("1 run, 1 failed", result.summary());
    }

    public void testFailedResultFormatting() {
        var result = new TestResult();
        result.testStarted();
        result.testFailed();
        assertEquals("1 run, 1 failed", result.summary());
    }

    public void testSuite() {
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        TestResult result = suite.run();
        assertEquals("2 run, 1 failed", result.summary());
    }

    public static void main(String[] args) {
        TestResult result = new TestResult();
        new TestCaseTest("testTemplateMethod").run(result);
        new TestCaseTest("testResult").run(result);
        new TestCaseTest("testFailedResult").run(result);
        new TestCaseTest("testFailedResultFormatting").run(result);
        new TestCaseTest("testSuite").run(result);
        System.out.println("result = " + result.summary());
    }
}
