import java.util.Arrays;

public class Solution960 {
    public int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                boolean flag = true;
                for (int i = 0; i < m; i++) {
                    if (strs[i].charAt(k) < strs[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    dp[k] = Math.max(dp[k], dp[j] + 1);
                }
            }
        }
        return n - Arrays.stream(dp).max().orElseThrow();
    }
}
/*
960. 删列造序 III
https://leetcode.cn/problems/delete-columns-to-make-sorted-iii/
给定由 n 个小写字母字符串组成的数组 strs ，其中每个字符串长度相等。
选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
比如，有 strs = ["abcdef","uvwxyz"] ，删除索引序列 {0, 2, 3} ，删除后为 ["bef", "vyz"] 。
假设，我们选择了一组删除索引 answer ，那么在执行删除操作之后，最终得到的数组的行中的 每个元素 都是按字典序排列的（即 (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]) 和 (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]) ，依此类推）。
请返回 answer.length 的最小可能值 。
提示：
n == strs.length
1 <= n <= 100
1 <= strs[i].length <= 100
strs[i] 由小写英文字母组成

动态规划
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */