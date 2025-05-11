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
        assertEquals("setUp testMethod ", test.log);
    }

    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
    }
}
