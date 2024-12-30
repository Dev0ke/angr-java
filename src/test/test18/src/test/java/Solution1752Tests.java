import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1752Tests {
    private final Solution1752 solution1752 = new Solution1752();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 1, 2};
        Assertions.assertTrue(solution1752.check(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 3, 4};
        Assertions.assertFalse(solution1752.check(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        Assertions.assertTrue(solution1752.check(nums));
    }
}
