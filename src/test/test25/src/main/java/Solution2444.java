public class Solution2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int len = nums.length;
        int minI = -1;
        int maxI = -1;
        int preI = -1;

        long res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == minK) {
                minI = i;
            }
            if (nums[i] == maxK) {
                maxI = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                preI = i;
            }
            res += Math.max(0, Math.min(minI, maxI) - preI);
        }
        return res;
    }
}
/*
2444. 统计定界子数组的数目
https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/

第 315 场周赛 T4。

给你一个整数数组 nums 和两个整数 minK 以及 maxK 。
- nums 的定界子数组是满足下述条件的一个子数组：
- 子数组中的 最小值 等于 minK 。
- 子数组中的 最大值 等于 maxK 。
返回定界子数组的数目。
子数组是数组中的一个连续部分。
提示：
2 <= nums.length <= 10^5
1 <= nums[i], minK, maxK <= 10^6

把 <minK 和 >maxK 的数当隔板，然后分别求两块隔板间符合要求的子数组数目，累加即可。
时间复杂度 O(n)
拓展：
原题 https://atcoder.jp/contests/abc247/tasks/abc247_e
https://codeforces.com/problemset/problem/1730/E
相似题目: 795. 区间子数组个数
https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/
 */