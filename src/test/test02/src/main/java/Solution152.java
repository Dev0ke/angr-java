public class Solution152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        // dpMax[i] 表示以第 i 个元素结尾的乘积最大子数组的乘积
        int[] dpMax = new int[len];
        // dpMin[i] 表示以第 i 个元素结尾的乘积最小子数组的乘积（nums[i] 有可能为负数，希望这个积尽可能「负得更多」，即尽可能小）
        int[] dpMin = new int[len];
        System.arraycopy(nums, 0, dpMax, 0, len);
        System.arraycopy(nums, 0, dpMin, 0, len);
        for (int i = 1; i < len; ++i) {
            // dpMax[i] = max(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i], nums[i])
            // dpMin[i] = min(dpMax[i-1]*nums[i], dpMin[i-1]*nums[i], nums[i])
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
        }
        int max = dpMax[0];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
/*
152. 乘积最大子数组
https://leetcode.cn/problems/maximum-product-subarray/

给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
提示:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数

与第 53 题的差异是: 当前位置的最优解未必是由前一个位置的最优解转移得到的。
需要根据正负性进行分类讨论
参考官方题解:
https://leetcode.cn/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/

动态规划
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
1594. 矩阵的最大非负积
https://leetcode.cn/problems/maximum-non-negative-product-in-a-matrix/description/
 */