import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1508Tests {
    private final Solution1508 solution1508 = new Solution1508();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        int expected = 13;
        Assertions.assertEquals(expected, solution1508.rangeSum(nums, n, left, right));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 3;
        int right = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution1508.rangeSum(nums, n, left, right));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 10;
        int expected = 50;
        Assertions.assertEquals(expected, solution1508.rangeSum(nums, n, left, right));
    }
}
