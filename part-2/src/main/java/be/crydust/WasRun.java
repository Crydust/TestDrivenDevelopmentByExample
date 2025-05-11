package be.crydust;

public class WasRun extends TestCase {
    public Boolean wasRun = null;
    public Boolean wasSetup = null;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        wasRun = false;
        wasSetup = true;
    }

    public void testMethod() {
        wasRun = true;
    }

}
