public class Solution2772 {
    // 2528
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            int delta = nums[i] + sumD;
            if (delta == 0) continue;
            if (delta < 0 || i + k > n) return false;
            sumD -= delta;
            diff[i + k] += delta;
        }
        return true;
    }
}
/*
2772. 使数组中的所有元素都等于零
https://leetcode.cn/problems/apply-operations-to-make-all-array-elements-equal-to-zero/

第 353 场周赛 T4。

给你一个下标从 0 开始的整数数组 nums 和一个正整数 k 。
你可以对数组执行下述操作 任意次 ：
- 从数组中选出长度为 k 的 任一 子数组，并将子数组中每个元素都 减去 1 。
如果你可以使数组中的所有元素都等于 0 ，返回  true ；否则，返回 false 。
子数组 是数组中的一个非空连续元素序列。
提示：
1 <= k <= nums.length <= 10^5
0 <= nums[i] <= 10^6

差分数组
时间复杂度 O(n)
相似题目: 2528. 最大化城市的最小供电站数目
https://leetcode.cn/problems/maximize-the-minimum-powered-city/
 */