import java.util.Arrays;

public class Solution2983 {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int n = s.length();
        // [0:n/2]
        char[] s1 = s.substring(0, n / 2).toCharArray();
        // rev[n/2:] j=n-1-i
        char[] s2 = new StringBuilder(s.substring(n / 2)).reverse().toString().toCharArray();

        int[][] psS = new int[n / 2 + 1][26];
        int[][] psT = new int[n / 2 + 1][26];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < 26; j++) {
                psS[i + 1][j] = psS[i][j] + (s1[i] - 'a' == j ? 1 : 0);
                psT[i + 1][j] = psT[i][j] + (s2[i] - 'a' == j ? 1 : 0);
            }
        }
        int[] psNe = new int[n / 2 + 1];
        for (int i = 0; i < n / 2; i++) {
            psNe[i + 1] = psNe[i] + (s1[i] != s2[i] ? 1 : 0);
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int l1 = queries[i][0], r1 = queries[i][1];
            int l2 = n - 1 - queries[i][3], r2 = n - 1 - queries[i][2];

            // 无法重新排列的部分 不相等
            // [0 : min(l1,l2)]
            // maybe r1 < l2 [r1+1:l2] or r2 < l1 [r2+1:l1]
            // [max(r1,r2)+1 : n/2]
            if (psNe[Math.min(l1, l2)] > 0 || psNe[n / 2] - psNe[Math.max(r1, r2) + 1] > 0) continue;
            if (r1 < l2 && psNe[l2] - psNe[r1 + 1] > 0) continue;
            if (r2 < l1 && psNe[l1] - psNe[r2 + 1] > 0) continue;

            ans[i] = l1 <= l2 ? check(l1, r1, l2, r2, psS, psT) : check(l2, r2, l1, r1, psT, psS);
        }
        return ans;
    }

    // l1 <= l2
    private boolean check(int l1, int r1, int l2, int r2, int[][] psS, int[][] psT) {
        // 区间包含 r2 <= r1
        if (r2 <= r1) {
            return Arrays.equals(count(psS, l1, r1), count(psT, l1, r1));
        }
        // 区间不相交 r1 < l2
        if (r1 < l2) {
            return Arrays.equals(count(psS, l1, r1), count(psT, l1, r1)) &&
                    Arrays.equals(count(psS, l2, r2), count(psT, l2, r2));
        }
        // 区间相交但不包含
        int[] s1 = subtract(count(psS, l1, r1), count(psT, l1, l2 - 1));
        int[] s2 = subtract(count(psT, l2, r2), count(psS, r1 + 1, r2));
        return s1 != null && s2 != null && Arrays.equals(s1, s2);
    }

    private int[] count(int[][] ps, int l, int r) {
        int[] res = ps[r + 1].clone();
        for (int i = 0; i < 26; i++) {
            res[i] -= ps[l][i];
        }
        return res;
    }

    private int[] subtract(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            s1[i] -= s2[i];
            if (s1[i] < 0) return null;
        }
        return s1;
    }
}
/*
2983. 回文串重新排列查询
https://leetcode.cn/problems/palindrome-rearrangement-queries/description/

第 378 场周赛 T4。

给你一个长度为 偶数 n ，下标从 0 开始的字符串 s 。
同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ai, bi, ci, di] 。
对于每个查询 i ，你需要执行以下操作：
- 将下标在范围 0 <= ai <= bi < n / 2 内的 子字符串 s[ai:bi] 中的字符重新排列。
- 将下标在范围 n / 2 <= ci <= di < n 内的 子字符串 s[ci:di] 中的字符重新排列。
对于每个查询，你的任务是判断执行操作后能否让 s 变成一个 回文串 。
每个查询与其他查询都是 独立的 。
请你返回一个下标从 0 开始的数组 answer ，如果第 i 个查询执行操作后，可以将 s 变为一个回文串，那么 answer[i] = true，否则为 false 。
- 子字符串 指的是一个字符串中一段连续的字符序列。
- s[x:y] 表示 s 中从下标 x 到 y 且两个端点 都包含 的子字符串。
提示：
2 <= n == s.length <= 10^5
1 <= queries.length <= 10^5
queries[i].length == 4
ai == queries[i][0], bi == queries[i][1]
ci == queries[i][2], di == queries[i][3]
0 <= ai <= bi < n / 2
n / 2 <= ci <= di < n
n 是一个偶数。
s 只包含小写英文字母。

大模拟。前缀和 + 区间重叠情况的分类讨论。
时间复杂度 O(n + q)。其中常数为 26。
 */