import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3139Tests {
    private final Solution3139 solution3139 = new Solution3139();

    @Test
    public void example1() {
        int[] nums = {4, 1};
        int cost1 = 5;
        int cost2 = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution3139.minCostToEqualizeArray(nums, cost1, cost2));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 3, 3, 5};
        int cost1 = 2;
        int cost2 = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution3139.minCostToEqualizeArray(nums, cost1, cost2));
    }

    @Test
    public void example3() {
        int[] nums = {3, 5, 3};
        int cost1 = 1;
        int cost2 = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3139.minCostToEqualizeArray(nums, cost1, cost2));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {1, 14, 14, 15};
        int cost1 = 2;
        int cost2 = 1;
        int expected = 20;
        Assertions.assertEquals(expected, solution3139.minCostToEqualizeArray(nums, cost1, cost2));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/problems/minimum-cost-to-equalize-array/submissions/531728337/
        // 取模错误
        int[] nums = {1, 1000000};
        int cost1 = 1000000;
        int cost2 = 1;
        int expected = 998993007;
        Assertions.assertEquals(expected, solution3139.minCostToEqualizeArray(nums, cost1, cost2));
    }
}