import java.util.Arrays;

public class Solution2746 {
    private int n;
    private String[] words;
    private int[][][] memo;

    public int minimizeConcatenatedLength(String[] words) {
        n = words.length;
        this.words = words;
        memo = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        String word = words[0];
        int pr = word.charAt(0) - 'a';
        int su = word.charAt(word.length() - 1) - 'a';
        int ans = 0;
        for (String s : words) {
            ans += s.length();
        }
        return ans - dfs(0, pr, su);
    }

    // 第 i 个单词，开头字符是 pre+'a'，结尾字符为 suf+'a'，的合并次数
    private int dfs(int i, int pre, int suf) {
        if (i == n - 1) {
            return 0;
        }
        if (memo[i][pre][suf] != -1) {
            return memo[i][pre][suf];
        }
        int res = 0;
        String word = words[i + 1];
        int pr = word.charAt(0) - 'a';
        int su = word.charAt(word.length() - 1) - 'a';
        // pr,su,pre,suf
        res = Math.max(res, dfs(i + 1, pr, suf) + (su == pre ? 1 : 0));
        // pre,suf,pr,su
        res = Math.max(res, dfs(i + 1, pre, su) + (suf == pr ? 1 : 0));
        return memo[i][pre][suf] = res;
    }
}
/*
2746. 字符串连接删减字母
https://leetcode.cn/problems/decremental-string-concatenation/

第 107 场双周赛 T3。

给你一个下标从 0 开始的数组 words ，它包含 n 个字符串。
定义 连接 操作 join(x, y) 表示将字符串 x 和 y 连在一起，得到 xy 。如果 x 的最后一个字符与 y 的第一个字符相等，连接后两个字符中的一个会被 删除 。
比方说 join("ab", "ba") = "aba" ， join("ab", "cde") = "abcde" 。
你需要执行 n - 1 次 连接 操作。令 str0 = words[0] ，从 i = 1 直到 i = n - 1 ，对于第 i 个操作，你可以执行以下操作之一：
- 令 stri = join(stri - 1, words[i])
- 令 stri = join(words[i], stri - 1)
你的任务是使 strn - 1 的长度 最小 。
请你返回一个整数，表示 strn - 1 的最小长度。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 50
words[i] 中只包含小写英文字母。

记忆化搜索
时间复杂度 O(n*C^2) 其中 C = 26
 */