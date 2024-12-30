import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3151Tests {
    private final Solution3151 solution3151 = new Solution3151();

    @Test
    public void example1() {
        int[] nums = {1};
        Assertions.assertTrue(solution3151.isArraySpecial(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 4};
        Assertions.assertTrue(solution3151.isArraySpecial(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 1, 6};
        Assertions.assertFalse(solution3151.isArraySpecial(nums));
    }
}