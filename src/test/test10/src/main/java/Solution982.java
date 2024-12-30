public class Solution982 {
    public int countTriplets(int[] nums) {
        int[] cnt = new int[1 << 16];
        for (int i : nums) {
            for (int j : nums) {
                cnt[i & j]++;
            }
        }

        int res = 0;
        for (int k : nums) {
            for (int ij = 0; ij < (1 << 16); ij++) {
                if ((k & ij) == 0) {
                    res += cnt[ij];
                }
            }
        }
        return res;
    }
}
/*
982. 按位与为零的三元组
https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/

给你一个整数数组 nums ，返回其中 按位与三元组 的数目。
按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件：
- 0 <= i < nums.length
- 0 <= j < nums.length
- 0 <= k < nums.length
- nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。
提示：
1 <= nums.length <= 1000
0 <= nums[i] < 2^16

三层循环 O(n^3) 会 TLE。需要使用类似 两数之和 的技巧优化至 O(n^2)
时间复杂度 O(n^2)
 */