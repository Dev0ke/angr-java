import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2219Tests {
    private final SolutionP2219 solutionP2219 = new SolutionP2219();

    @Test
    public void example1() {
        int[] nums = {4, 3, -2, 5};
        long expected = 10;
        Assertions.assertEquals(expected, solutionP2219.maximumSumScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, -5};
        long expected = -3;
        Assertions.assertEquals(expected, solutionP2219.maximumSumScore(nums));
    }
}