package be.crydust;

public class TestResult {
    private int runCount = 0;
    private String summary;

    public void testStarted() {
        runCount++;
    }

    public String summary() {
        return "%d run, 0 failed".formatted(runCount);
    }
}
