import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2395Tests {
    private final Solution2395 solution2395 = new Solution2395();

    @Test
    public void example1() {
        int[] nums = {4, 2, 4};
        Assertions.assertTrue(solution2395.findSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertFalse(solution2395.findSubarrays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 0, 0};
        Assertions.assertTrue(solution2395.findSubarrays(nums));
    }
}
