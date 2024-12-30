import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2784Tests {
    private final Solution2784 solution2784 = new Solution2784();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        Assertions.assertFalse(solution2784.isGood(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3, 2};
        Assertions.assertTrue(solution2784.isGood(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1};
        Assertions.assertTrue(solution2784.isGood(nums));
    }

    @Test
    public void example4() {
        int[] nums = {3, 4, 4, 1, 2, 1};
        Assertions.assertFalse(solution2784.isGood(nums));
    }
}