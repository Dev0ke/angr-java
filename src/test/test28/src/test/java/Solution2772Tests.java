import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2772Tests {
    private final Solution2772 solution2772 = new Solution2772();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 1, 1, 0};
        int k = 3;
        Assertions.assertTrue(solution2772.checkArray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 1, 1};
        int k = 2;
        Assertions.assertFalse(solution2772.checkArray(nums, k));
    }
}