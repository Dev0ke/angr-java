public class Solution2778 {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }
}
/*
2778. 特殊元素平方和
https://leetcode.cn/problems/sum-of-squares-of-special-elements/

第 354 场周赛 T1。

给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
对 nums 中的元素 nums[i] 而言，如果 n 能够被 i 整除，即 n % i == 0 ，则认为 num[i] 是一个 特殊元素 。
返回 nums 中所有 特殊元素 的 平方和 。
提示：
1 <= nums.length == n <= 50
1 <= nums[i] <= 50

枚举
时间复杂度 O(n)
 */