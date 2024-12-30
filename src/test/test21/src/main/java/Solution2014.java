import java.util.Arrays;

public class Solution2014 {
    private char[] cs;
    private int n, k;
    private int[][] nxt;
    private StringBuilder a;
    private String ans;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.cs = s.toCharArray();
        this.n = s.length();
        this.k = k;

        // 子序列自动机
        int[] pos = new int[26];
        Arrays.fill(pos, n);
        nxt = new int[n][26];
        for (int i = n - 1; i >= 0; i--) {
//            nxt[i] = pos.clone();
            System.arraycopy(pos, 0, nxt[i], 0, 26);
            pos[cs[i] - 'a'] = i;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[cs[i] - 'a']++;
        }
        // 计算所有可能出现在答案中的字符，包括重复的
        // 倒着统计，这样下面计算排列时的第一个合法方案就是答案，从而提前退出
        a = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            for (int c = cnt[i]; c >= k; c -= k) {
                a.append((char) ('a' + i));
            }
        }

        ans = "";
        // 从大到小枚举答案长度 m
        for (int m = a.length(); m > 0 && ans.equals(""); m--) {
            // 枚举长度为 m 的所有排列
            permutations(a.length(), m);
        }
        return ans;
    }

    // 模板：生成 n 选 r 的排列
    private void permutations(int n, int r) {
        int[] ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        if (func_do(Arrays.copyOfRange(ids, 0, r))) {
            return;
        }
        int[] cycles = new int[r];
        for (int i = 0; i < r; i++) {
            cycles[i] = n - i;
        }
        while (true) {
            int i = r - 1;
            for (; i >= 0; i--) {
                cycles[i]--;
                if (cycles[i] == 0) {
                    int tmp = ids[i];
                    // copy(ids[i:], ids[i+1:])
                    for (int j = i; j <= n - 2; j++) {
                        ids[j] = ids[j + 1];
                    }
                    ids[n - 1] = tmp;
                    cycles[i] = n - i;
                } else {
                    int j = cycles[i];
                    // ids[i], ids[n-j] = ids[n-j], ids[i]
                    int tmp = ids[i];
                    ids[i] = ids[n - j];
                    ids[n - j] = tmp;
                    if (func_do(Arrays.copyOfRange(ids, 0, r))) {
                        return;
                    }
                    break;
                }
            }
            if (i == -1) {
                return;
            }
        }
    }

    private boolean func_do(int[] ids) {
        int m = ids.length;
        char[] t = new char[m];
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            t[i] = a.charAt(id);
        }
        int i = 0, j = 0;
        if (t[0] == cs[0]) {
            j = 1;
        }
        while (true) {
            i = nxt[i][t[j % m] - 'a'];
            if (i == n) {
                break;
            }
            j++;
        }
        if (j >= k * m) {
            ans = new String(t);
            return true;
        }
        return false;
    }
}
/*
2014. 重复 K 次的最长子序列
https://leetcode.cn/problems/longest-subsequence-repeated-k-times/

第 259 场周赛 T4。

给你一个长度为 n 的字符串 s ，和一个整数 k 。请你找出字符串 s 中 重复 k 次的 最长子序列 。
子序列 是由其他字符串删除某些（或不删除）字符派生而来的一个字符串。
如果 seq * k 是 s 的一个子序列，其中 seq * k 表示一个由 seq 串联 k 次构造的字符串，那么就称 seq 是字符串 s 中一个 重复 k 次 的子序列。
- 举个例子，"bba" 是字符串 "bababcba" 中的一个重复 2 次的子序列，因为字符串 "bbabba" 是由 "bba" 串联 2 次构造的，而 "bbabba" 是字符串 "bababcba" 的一个子序列。
返回字符串 s 中 重复 k 次的最长子序列  。如果存在多个满足的子序列，则返回 字典序最大 的那个。如果不存在这样的子序列，返回一个 空 字符串。
提示：
n == s.length
2 <= k <= 2000
2 <= n < k * 8
s 由小写英文字母组成

子序列自动机
 */