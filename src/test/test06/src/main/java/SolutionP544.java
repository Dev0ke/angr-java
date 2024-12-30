public class SolutionP544 {
    private int[] team;
    private int t;
    private StringBuilder ans;

    public String findContestMatch(int n) {
        team = new int[n];
        t = 0;
        ans = new StringBuilder();
        dfs(n, Integer.numberOfTrailingZeros(n));
        return ans.toString();
    }

    private void dfs(int n, int round) {
        if (round == 0) {
            int w = Integer.lowestOneBit(t);
            team[t] = w > 0 ? n / w + 1 - team[t - w] : 1;
            ans.append(team[t++]);
        } else {
            ans.append("(");
            dfs(n, round - 1);
            ans.append(",");
            dfs(n, round - 1);
            ans.append(")");
        }
    }
}
/*
$544. 输出比赛匹配对
https://leetcode.cn/problems/output-contest-matches/description/

在 NBA 季后赛期间，我们总是安排相对强大的球队与相对弱小的球队比赛，就像让排名第 1 的球队与排名第 n 的球队比赛一样，这是一种使比赛更加有趣的好策略。
现给定 n 支球队，请以字符串的形式返回它们的最终的比赛匹配方案。
这 n 支球队从 1 到 n 进行标记，代表它们的初始排名（即，排名 1 的是最强的球队，排名 n 的是最弱的球队）。
我们将使用括号 '(' 和 ')' 以及逗号 ',' 来表示比赛的匹配情况。我们使用括号来表示匹配，逗号来表示分组。在每一轮的匹配过程中，你总是需要遵循使相对强大的球队与相对弱小的球队配对的策略。
提示：
n == 2x，并且 x 在范围 [1,12] 内。

线性输出。
时间复杂度 O(n)。
 */