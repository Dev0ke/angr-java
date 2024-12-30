public class Solution3264 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        while (k-- > 0) {
            int minI = 0;
            for (int i = 0; i < n; i++) {
                if (nums[minI] > nums[i]) {
                    minI = i;
                }
            }
            nums[minI] *= multiplier;
        }
        return nums;
    }
}
/*
3264. K 次乘运算后的最终数组 I
https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-i/description/

第 412 场周赛 T1。

给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
你需要对 nums 执行 k 次操作，每次操作中：
- 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
- 将 x 替换为 x * multiplier 。
请你返回执行完 k 次乘运算之后，最终的 nums 数组。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 10
1 <= multiplier <= 5

模拟。
时间复杂度 O(kn)。
 */