import java.util.Arrays;

public class Solution3144 {
    private char[] s;
    private int[] memo;

    public int minimumSubstringsInPartition(String S) {
        s = S.toCharArray();
        int n = s.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int res = Integer.MAX_VALUE;
        int[] cnt = new int[26];
        for (int j = i; j >= 0; j--) {
            cnt[s[j] - 'a']++;
            if (check(cnt)) {
                res = Math.min(res, dfs(j - 1) + 1);
            }
        }
        return memo[i] = res;
    }

    private boolean check(int[] cnt) {
        int each_one = -1;
        for (int c : cnt) {
            if (c == 0) continue;
            if (each_one == -1 || each_one == c) each_one = c;
            else return false;
        }
        return true;
    }
}
/*
3144. 分割字符频率相等的最少子字符串
https://leetcode.cn/problems/minimum-substring-partition-of-equal-character-frequency/description/

第 130 场双周赛 T3。

给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。比方说，s == "ababcc" 那么 ("abab", "c", "c") ，("ab", "abc", "c") 和 ("ababcc") 都是合法分割，
但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和 ("ab", "abcc") 不是，不平衡的子字符串用粗体表示。
请你返回 s 最少 能分割成多少个平衡子字符串。
注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。
提示：
1 <= s.length <= 1000
s 只包含小写英文字母。

记忆化搜索 / 划分型 DP §6.2 计算划分个数
时间复杂度 O(n^2)。
 */