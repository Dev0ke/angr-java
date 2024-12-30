import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3011Tests {
    private final Solution3011 solution3011 = new Solution3011();

    @Test
    public void example1() {
        int[] nums = {8, 4, 2, 30, 15};
        Assertions.assertTrue(solution3011.canSortArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solution3011.canSortArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 16, 8, 4, 2};
        Assertions.assertFalse(solution3011.canSortArray(nums));
    }
}