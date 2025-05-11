package be.crydust;

public class TestCase {
    private final String name;

    public TestCase(String name) {
        this.name = name;
    }

    public void setUp() {
        // NOOP
    }

    public void run() {
        this.setUp();
        try {
            this.getClass()
                    .getDeclaredMethod(name)
                    .invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.tearDown();
    }

    public void tearDown() {
        // NOOP
    }

}
