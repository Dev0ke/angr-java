public class Solution2176 {
    public int countPairs(int[] nums, int k) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2176. 统计数组中相等且可以被整除的数对
https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/

第 72 场双周赛 T1。

给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
提示：
1 <= nums.length <= 100
1 <= nums[i], k <= 100

暴力模拟。
时间复杂度 O(n^2)
 */