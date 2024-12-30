import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution330Tests {
    private final Solution330 solution330 = new Solution330();

    @Test
    public void example1() {
        int[] nums = {1, 3};
        int n = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution330.minPatches(nums, n));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 10};
        int n = 20;
        int expected = 2;
        Assertions.assertEquals(expected, solution330.minPatches(nums, n));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 2};
        int n = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution330.minPatches(nums, n));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/patching-array/submissions/486422653/
        int[] nums = {1, 2, 31, 33};
        int n = 2147483647;
        int expected = 28;
        Assertions.assertEquals(expected, solution330.minPatches(nums, n));
    }
}
