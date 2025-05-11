package be.crydust;

public class WasRun extends TestCase {
    public String log = "";

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        log += "setUp ";
    }

    public void testMethod() {
        log += "testMethod ";
    }

    public void testBrokenMethod() {
        throw new RuntimeException("fail on purpose");
    }

    @Override
    public void tearDown() {
        log += "tearDown ";
    }

}
