import java.util.List;

public class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
/*
2859. 计算 K 置位下标对应元素的和
https://leetcode.cn/problems/sum-of-values-at-indices-with-k-set-bits/

第 363 场周赛 T1。

给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
整数的二进制表示中的 1 就是这个整数的 置位 。
例如，21 的二进制表示为 10101 ，其中有 3 个置位。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^5
0 <= k <= 10

库函数 bitCount
 */