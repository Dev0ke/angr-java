public class Solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt++;
                res += cnt;
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}
/*
2348. 全 0 子数组的数目
https://leetcode.cn/problems/number-of-zero-filled-subarrays/

第 83 场双周赛 T2。

给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
子数组 是一个数组中一段连续非空元素组成的序列。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

计数。连续 0 个数的长度贡献累加。
 */