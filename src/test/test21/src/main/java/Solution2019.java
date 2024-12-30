import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2019 {
    private char[] cs;
    private List<List<Set<Integer>>> dp;

    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length();
        cs = s.toCharArray();

        int correct = 0;
        int i = 0;
        while (i < n) {
            int mul = cs[i] - '0';
            for (i += 2; i < n && cs[i - 1] == '*'; i += 2) {
                mul *= cs[i] - '0';
            }
            correct += mul;
        }

        // 区间 DP
        // dp[l][r] 表示 s[l..r] 内的表达式在不同计算顺序下的不超过 1000 的所有可能值
        dp = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            List<Set<Integer>> list = new ArrayList<>(n);
            for (int k = 0; k < n; k++) {
                list.add(new HashSet<>());
            }
            dp.add(list);
        }
        f(0, n - 1);

        int ans = 0;
        for (int x : answers) {
            if (x == correct) {
                ans += 5;
            } else if (dp.get(0).get(n - 1).contains(x)) {
                ans += 2;
            }
        }
        return ans;
    }

    private void f(int l, int r) {
        if (l == r) {
            dp.get(l).get(r).add(cs[l] & 15);
            return;
        }
        if (!dp.get(l).get(r).isEmpty()) {
            return;
        }

        for (int i = l + 1; i < r; i += 2) {
            f(l, i - 1);
            f(i + 1, r);
            for (Integer lVal : dp.get(l).get(i - 1)) {
                for (Integer rVal : dp.get(i + 1).get(r)) {
                    int x = cs[i] == '*' ? lVal * rVal : lVal + rVal;
                    if (x <= 1000) {
                        dp.get(l).get(r).add(x);
                    }
                }
            }
        }
    }
}
/*
2019. 解出数学表达式的学生分数
https://leetcode.cn/problems/the-score-of-students-solving-math-expression/

第 260 场周赛 T4。

给你一个字符串 s ，它 只 包含数字 0-9 ，加法运算符 '+' 和乘法运算符 '*' ，这个字符串表示一个 合法 的只含有 个位数数字 的数学表达式（比方说 3+5*2）。有 n 位小学生将计算这个数学表达式，并遵循如下 运算顺序 ：
1.按照 从左到右 的顺序计算 乘法 ，然后
2.按照 从左到右 的顺序计算 加法 。
给你一个长度为 n 的整数数组 answers ，表示每位学生提交的答案。你的任务是给 answer 数组按照如下 规则 打分：
- 如果一位学生的答案 等于 表达式的正确结果，这位学生将得到 5 分。
- 否则，如果答案由 一处或多处错误的运算顺序 计算得到，那么这位学生能得到 2 分。
- 否则，这位学生将得到 0 分。
请你返回所有学生的分数和。
提示：
3 <= s.length <= 31
s 表示一个只包含 0-9 ，'+' 和 '*' 的合法表达式。
表达式中所有整数运算数字都在闭区间 [0, 9] 以内。
1 <= 数学表达式中所有运算符数目（'+' 和 '*'） <= 15
测试数据保证正确表达式结果在范围 [0, 1000] 以内。
n == answers.length
1 <= n <= 10^4
0 <= answers[i] <= 1000

区间 DP
 */