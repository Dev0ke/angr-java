public class Solution3091 {
    public int minOperations(int k) {
        int ans = k;
        for (int x = 0; x < k; x++) {
            ans = Math.min(ans, x + (k - 1) / (x + 1));
        }
        return ans;
    }
}
/*
3091. 执行操作使数据元素之和大于等于 K
https://leetcode.cn/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/description/

第 390 场周赛 T2。

给你一个正整数 k 。最初，你有一个数组 nums = [1] 。
你可以对数组执行以下 任意 操作 任意 次数（可能为零）：
- 选择数组中的任何一个元素，然后将它的值 增加 1 。
- 复制数组中的任何一个元素，然后将它附加到数组的末尾。
返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数。
提示：
1 <= k <= 10^5

枚举。
操作 x 次。f(x) = x + (k-1)/(1+x)
时间复杂度 O(k)
 */