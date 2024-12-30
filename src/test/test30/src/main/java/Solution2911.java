import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2911 {
    private static final int INF = (int) 1e9;
    private static final int MX = 201;
    private static final List<Integer>[] divisors;

    private int[][] modify;
    private int[][] memo;

    static {
        // 预处理 n 的所有真因子 O(MXlogMX)
        divisors = new ArrayList[MX];
        Arrays.setAll(divisors, e -> new ArrayList<>());
        for (int i = 1; i < MX; i++) {
            for (int j = i * 2; j < MX; j += i) {
                divisors[j].add(i);
            }
        }
    }

    public int minimumChanges(String s, int k) {
        int n = s.length();

        // O(n^3 logn)
        modify = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                modify[i][j] = getModify(s.substring(i, j + 1));
            }
        }

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(k - 1, n - 1);
    }

    // i 定义成剩余需要切割的次数
    // i+1 就是切出来的子串的个数
    // j 从 s[0] 到 s[j] 是现在需要切割的部分
    // 返回值 修改的最少字符数目
    // 枚举当前这一段的左端点 L [2i, j-1]
    // 设 modify[i][j] 表 s[i..j] 的最小修改次数
    // dfs(i,j) <= min dfs(i-1, L-1) + modify[L][j]
    // 递归终点 i=0 return modify[0][j]
    // 递归入口 dfs(k-1, n-1)
    private int dfs(int i, int j) {
        if (i == 0) {
            return modify[0][j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = INF;
        for (int L = i * 2; L < j; L++) {
            res = Math.min(res, dfs(i - 1, L - 1) + modify[L][j]);
        }
        return memo[i][j] = res;
    }

    // O(nlogn)
    private int getModify(String s) {
        int n = s.length();
        int min_cnt = INF;
        for (Integer d : divisors[n]) {
            int cnt = 0;
            for (int i = 0; i < d; i++) {
                StringBuilder t = new StringBuilder();
                for (int j = i; j < n; j += d) {
                    t.append(s.charAt(j));
                }
                for (int j = 0; j < t.length() / 2; j++) {
                    if (t.charAt(j) != t.charAt(t.length() - 1 - j)) {
                        cnt++;
                    }
                }
            }
            min_cnt = Math.min(min_cnt, cnt);
        }
        return min_cnt;
    }
}
/*
2911. 得到 K 个半回文串的最少修改次数
https://leetcode.cn/problems/minimum-changes-to-make-k-semi-palindromes/description/

第 368 场周赛 T4。

给你一个字符串 s 和一个整数 k ，请你将 s 分成 k 个 子字符串 ，使得每个 子字符串 变成 半回文串 需要修改的字符数目最少。
请你返回一个整数，表示需要修改的 最少 字符数目。
注意：
- 如果一个字符串从左往右和从右往左读是一样的，那么它是一个 回文串 。
- 如果长度为 len 的字符串存在一个满足 1 <= d < len 的正整数 d ，len % d == 0 成立且所有对 d 做除法余数相同的下标对应的字符连起来得到的字符串都是 回文串 ，那么我们说这个字符串是 半回文串 。比方说 "aa" ，"aba" ，"adbgad" 和 "abab" 都是 半回文串 ，而 "a" ，"ab" 和 "abca" 不是。
- 子字符串 指的是一个字符串中一段连续的字符序列。
提示：
2 <= s.length <= 200
1 <= k <= s.length / 2
s 只包含小写英文字母。

划分型 DP
预处理 + 记忆化搜索
时间复杂度 O(n^3 * logn)
空间复杂度 O(n^2)
---
分成（恰好/至多）k 个连续区间
相似题目: 410. 分割数组的最大值
https://leetcode.cn/problems/split-array-largest-sum/
813. 最大平均值和的分组
https://leetcode.cn/problems/largest-sum-of-averages/
1278. 分割回文串 III
https://leetcode.cn/problems/palindrome-partitioning-iii/
1335. 工作计划的最低难度
https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/description/
2478. 完美分割的方案数
https://leetcode.cn/problems/number-of-beautiful-partitions/
---
最小化分割出的区间个数 / 元素总和等
相似题目: 132. 分割回文串 II
https://leetcode.cn/problems/palindrome-partitioning-ii/
2707. 字符串中的额外字符
https://leetcode.cn/problems/extra-characters-in-a-string/
2767. 将字符串分割为最少的美丽子字符串
https://leetcode.cn/problems/partition-string-into-minimum-beautiful-substrings/
1105. 填充书架
https://leetcode.cn/problems/filling-bookcase-shelves/
 */