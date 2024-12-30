import java.util.HashMap;
import java.util.Map;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        // dp[i] 表示以 arr[i] 结尾的前 i 个元素最长定差子序列，结果为 max(dp[i])
        // dp[x] = dp[x-d]+1
        Map<Integer, Integer> dp = new HashMap<>();
        for (int x : arr) {
            dp.put(x, dp.getOrDefault(x - difference, 0) + 1);
        }
        return dp.values().stream().max(Integer::compareTo).orElseThrow();
    }
}
/*
1218. 最长定差子序列
https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/

给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
提示：
1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4

动态规划
 */