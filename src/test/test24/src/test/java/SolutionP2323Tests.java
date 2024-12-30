import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2323Tests {
    private final SolutionP2323 solutionP2323 = new SolutionP2323();

    @Test
    public void example1() {
        int[] jobs = {5, 2, 4};
        int[] workers = {1, 7, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2323.minimumTime(jobs, workers));
    }

    @Test
    public void example2() {
        int[] jobs = {3, 18, 15, 9};
        int[] workers = {6, 5, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2323.minimumTime(jobs, workers));
    }
}