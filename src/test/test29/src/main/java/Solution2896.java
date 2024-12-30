import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2896 {
    private int x;
    private List<Integer> a;
    private static final int INF = (int) 1e9;
    private int[] memo;

    public int minOperations(String s1, String s2, int x) {
        this.x = x;
        a = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                a.add(i);
            }
        }
        int m = a.size();
        if (m % 2 == 1) {
            return -1;
        }

        memo = new int[m];
        Arrays.fill(memo, -1);
        return dfs(m - 1) / 2;
    }

    // 第 1 种操作 dfs(i-1) + x/2
    // 第 2 种操作 dfs(i-2) + (p[i] - p[i-1])
    private int dfs(int i) {
        if (i == -2) return INF;
        if (i == -1) return 0;
        if (memo[i] != -1) {
            return memo[i];
        }
        int res1 = dfs(i - 1) + x;
        int res2 = dfs(i - 2) + (i - 1 >= 0 ? (a.get(i) - a.get(i - 1)) * 2 : 0);
        int res = Math.min(res1, res2);
        return memo[i] = res;
    }
}
/*
2896. 执行操作使两个字符串相等
https://leetcode.cn/problems/apply-operations-to-make-two-strings-equal/description/

第 366 场周赛 T3。

给你两个下标从 0 开始的二进制字符串 s1 和 s2 ，两个字符串的长度都是 n ，再给你一个正整数 x 。
你可以对字符串 s1 执行以下操作 任意次 ：
- 选择两个下标 i 和 j ，将 s1[i] 和 s1[j] 都反转，操作的代价为 x 。
- 选择满足 i < n - 1 的下标 i ，反转 s1[i] 和 s1[i + 1] ，操作的代价为 1 。
请你返回使字符串 s1 和 s2 相等的 最小 操作代价之和，如果无法让二者相等，返回 -1 。
注意 ，反转字符的意思是将 0 变成 1 ，或者 1 变成 0 。
提示：
n == s1.length == s2.length
1 <= n, x <= 500
s1 和 s2 只包含字符 '0' 和 '1' 。

记忆化搜索。
为了避免 x 为奇数，先 *2 然后结果再 /2
时间复杂度 O(n)
相似题目: D2. Zero-One (Hard Version)
https://codeforces.com/contest/1733/problem/D2
 */