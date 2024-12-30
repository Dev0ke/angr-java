import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1004Tests {
    private final Solution1004 solution1004 = new Solution1004();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1004.longestOnes(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solution1004.longestOnes(nums, k));
    }
}
