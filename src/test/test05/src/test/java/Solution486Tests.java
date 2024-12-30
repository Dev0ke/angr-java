import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution486Tests {
    private final Solution486 solution486 = new Solution486();

    @Test
    public void example1() {
        int[] nums = {1, 5, 2};
        Assertions.assertFalse(solution486.PredictTheWinner(nums));
        Assertions.assertFalse(solution486.PredictTheWinner2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 233, 7};
        Assertions.assertTrue(solution486.PredictTheWinner(nums));
        Assertions.assertTrue(solution486.PredictTheWinner2(nums));
    }
}
