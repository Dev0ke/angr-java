public class Solution2006 {
    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
2006. 差的绝对值为 K 的数对数目
https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/

第 61 场双周赛 T1。

给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
|x| 的值定义为：
- 如果 x >= 0 ，那么值为 x 。
- 如果 x < 0 ，那么值为 -x 。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99

用例数值范围很小，直接暴力即可。
时间复杂度 O(n^2)
 */