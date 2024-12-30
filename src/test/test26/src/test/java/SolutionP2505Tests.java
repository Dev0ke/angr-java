import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2505Tests {
    private final SolutionP2505 solutionP2505 = new SolutionP2505();

    @Test
    public void example1() {
        int[] nums = {2, 1, 0, 3};
        long expected = 7;
        Assertions.assertEquals(expected, solutionP2505.subsequenceSumOr(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2505.subsequenceSumOr(nums));
    }
}