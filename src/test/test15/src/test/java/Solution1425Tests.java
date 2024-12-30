import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1425Tests {
    private final Solution1425 solution1425 = new Solution1425();

    @Test
    public void example1() {
        int[] nums = {10, 2, -10, 5, 20};
        int k = 2;
        int expected = 37;
        Assertions.assertEquals(expected, solution1425.constrainedSubsetSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -2, -3};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution1425.constrainedSubsetSum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {10, -2, -10, -5, 20};
        int k = 2;
        int expected = 23;
        Assertions.assertEquals(expected, solution1425.constrainedSubsetSum(nums, k));
    }
}