import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1793Tests {
    private final Solution1793 solution1793 = new Solution1793();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 7, 4, 5};
        int k = 3;
        int expected = 15;
        Assertions.assertEquals(expected, solution1793.maximumScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 4, 5, 4, 1, 1, 1};
        int k = 0;
        int expected = 20;
        Assertions.assertEquals(expected, solution1793.maximumScore(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872};
        int k = 5;
        int expected = 9732;
        Assertions.assertEquals(expected, solution1793.maximumScore(nums, k));
    }
}