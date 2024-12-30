import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1296Tests {
    private final Solution1296 solution1296 = new Solution1296();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        int k = 4;
        Assertions.assertTrue(solution1296.isPossibleDivide(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11};
        int k = 3;
        Assertions.assertTrue(solution1296.isPossibleDivide(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 3, 2, 2, 1, 1};
        int k = 3;
        Assertions.assertTrue(solution1296.isPossibleDivide(nums, k));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        Assertions.assertFalse(solution1296.isPossibleDivide(nums, k));
    }
}
