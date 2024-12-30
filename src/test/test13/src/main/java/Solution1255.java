public class Solution1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;

        // 预处理 fs[i] 表示第 i 个单词分数；cost[i] 表示第 i 个单词所需字母
        int[] fs = new int[n];
        int[][] cost = new int[n][26];
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (char ch : words[i].toCharArray()) {
                cost[i][ch - 'a']++;
                s += score[ch - 'a'];
            }
            fs[i] = s;
        }
        // tot 表示各字符可用的数量
        int[] tot = new int[26];
        for (char ch : letters) {
            tot[ch - 'a']++;
        }

        int max = 0;
        // 状态压缩
        for (int mask = 1; mask < (1 << n); mask++) {
            int[] need = new int[26];
            int s = 0;
            for (int k = 0; k < n; k++) {
                if (((mask >> k) & 1) == 1) {
                    for (int i = 0; i < 26; i++) {
                        need[i] += cost[k][i];
                        if (need[i] > tot[i]) {
                            // 状态不成立
                            s = -1;
                            break;
                        }
                    }
                    if (s < 0) break;
                    s += fs[k];
                }
            }
            max = Math.max(max, s);
        }
        return max;
    }
}
/*
1255. 得分最高的单词集合
https://leetcode.cn/problems/maximum-score-words-formed-by-letters/

你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
单词拼写游戏的规则概述如下：
- 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
- 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
- 单词表 words 中每个单词只能计分（使用）一次。
- 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
- 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
提示：
1 <= words.length <= 14
1 <= words[i].length <= 15
1 <= letters.length <= 100
letters[i].length == 1
score.length == 26
0 <= score[i] <= 10
words[i] 和 letters[i] 只包含小写的英文字母。

状态压缩枚举
时间复杂度 O(n * 2^n)
空间复杂度 O(n)
 */