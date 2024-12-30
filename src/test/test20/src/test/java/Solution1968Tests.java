import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1968Tests {
    private final Solution1968 solution1968 = new Solution1968();

    private boolean checkArray(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == nums[i] + nums[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 4, 5, 3};
        Assertions.assertTrue(checkArray(solution1968.rearrangeArray(nums)));
    }

    @Test
    public void example2() {
        int[] nums = {6, 2, 0, 9, 7};
        int[] expected = {9, 7, 6, 2, 0};
        Assertions.assertTrue(checkArray(solution1968.rearrangeArray(nums)));
    }
}
