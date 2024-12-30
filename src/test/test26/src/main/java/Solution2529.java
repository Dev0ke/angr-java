public class Solution2529 {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}
/*
2529. 正整数和负整数的最大计数
https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/

第 327 场周赛 T1。

给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
- 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
注意：0 既不是正整数也不是负整数。
提示：
1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums 按 非递减顺序 排列。

枚举
时间复杂度 O(n)
 */