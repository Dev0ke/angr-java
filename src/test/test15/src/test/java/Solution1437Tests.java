import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1437Tests {
    private final Solution1437 solution1437 = new Solution1437();

    @Test
    public void example1() {
        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        int k = 2;
        Assertions.assertTrue(solution1437.kLengthApart(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 2;
        Assertions.assertFalse(solution1437.kLengthApart(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;
        Assertions.assertTrue(solution1437.kLengthApart(nums, k));
    }

    @Test
    public void example4() {
        int[] nums = {0, 1, 0, 1};
        int k = 1;
        Assertions.assertTrue(solution1437.kLengthApart(nums, k));
    }
}