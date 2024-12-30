import java.util.Arrays;

public class Solution2767 {
    private static final String[] TABLE = {
            "1",
            "101",
            "11001",
            "1111101",
            "1001110001",
            "110000110101",
            "11110100001001",
    };

    private String s;
    private int n;
    private int[] memo;

    public int minimumBeautifulSubstrings(String s) {
        this.s = s;
        this.n = s.length();

        memo = new int[n];
        Arrays.fill(memo, -1);
        int ans = dfs(0);
        return ans == n + 1 ? -1 : ans;
    }

    private int dfs(int i) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        int res = n + 1;
        for (String pre : TABLE) {
            if (s.substring(i).startsWith(pre)) {
                res = Math.min(res, dfs(i + pre.length()) + 1);
            }
        }
        return memo[i] = res;
    }
}
/*
2767. 将字符串分割为最少的美丽子字符串
https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings/

第 108 场双周赛 T3。

给你一个二进制字符串 s ，你需要将字符串分割成一个或者多个 子字符串  ，使每个子字符串都是 美丽 的。
如果一个字符串满足以下条件，我们称它是 美丽 的：
- 它不包含前导 0 。
- 它是 5 的幂的 二进制 表示。
请你返回分割后的子字符串的 最少 数目。如果无法将字符串 s 分割成美丽子字符串，请你返回 -1 。
子字符串是一个字符串中一段连续的字符序列。
提示：
1 <= s.length <= 15
s[i] 要么是 '0' 要么是 '1' 。

动态规划。
本题不能贪心。但数据量小，可以 bfs
时间复杂度 O(n^2) startsWith 近似看成 O(1)
 */