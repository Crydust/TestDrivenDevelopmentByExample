package be.crydust;

public class WasRun {
    private final String testMethod;
    public boolean wasRun;

    public WasRun(String testMethod) {
        this.testMethod = testMethod;
    }

    public void testMethod() {
        wasRun = true;
    }

    public void run() {
        try {
            this.getClass()
                    .getDeclaredMethod(testMethod)
                    .invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
