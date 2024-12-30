import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3046Tests {
    private final Solution3046 solution3046 = new Solution3046();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 3, 4};
        Assertions.assertTrue(solution3046.isPossibleToSplit(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1};
        Assertions.assertFalse(solution3046.isPossibleToSplit(nums));
    }
}