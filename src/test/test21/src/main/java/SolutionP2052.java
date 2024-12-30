import java.util.Arrays;

public class SolutionP2052 {
    private int k, n;
    private int[] ps, memo;

    public int minimumCost(String sentence, int k) {
        this.k = k;
        String[] sp = sentence.split(" ");
        n = sp.length;
        ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + sp[i].length();
        }

        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (ps[n] - ps[i] + n - 1 - i <= k) return 0;
        if (memo[i] != -1) return memo[i];
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j < n && ps[j] - ps[i] + j - 1 - i <= k; j++) {
            int nxt = ps[j] - ps[i] + j - 1 - i;
            res = Math.min(res, (k - nxt) * (k - nxt) + dfs(j));
        }
        return memo[i] = res;
    }
}
/*
$2052. 将句子分隔成行的最低成本
https://leetcode.cn/problems/minimum-cost-to-separate-sentence-into-rows/description/

给定一个由空格分隔的单词组成的字符串 sentence 和一个整数 k。你的任务是将 sentence 分成多行，每行中的字符数最多为 k。你可以假设 sentence 不以空格开头或结尾，并且 sentence 中的单词由单个空格分隔。
你可以通过在 sentence 中的单词间插入换行来分隔 sentence 。一个单词不能被分成两行。每个单词只能使用一次，并且单词顺序不能重排。同一行中的相邻单词应该由单个空格分隔，并且每行都不应该以空格开头或结尾。
一行长度为 n 的字符串的分隔成本是 (k - n)^2 ，总成本就是除开最后一行以外的其它所有行的分隔成本之和。
- 以 sentence = "i love leetcode" 和k = 12为例：
  - 将sentence 分成 "i", "love", 和"leetcode" 的成本为 (12 - 1)^2 + (12 - 4)^2 = 185。
  - 将sentence 分成 "i love", 和"leetcode" 的成本为 (12 - 6)^2 = 36。
  - 将sentence 分成 "i", 和"love leetcode" 是不可能的，因为 "love leetcode" 的长度大于 k。
返回将sentence分隔成行的最低的可能总成本。
提示:
1 <= sentence.length <= 5000
1 <= k <= 5000
sentence 中每个单词长度最大为 k.
sentence 只包含小写字母和空格.
sentence 不会以空格开头或结尾.
sentence 中的单词以单个空格分隔.

记忆化搜索。
时间复杂度 O(n^2)。
 */