import java.util.ArrayList;
import java.util.List;

public class Solution843 {
    private int[][] H;

    public void findSecretWord(String[] words, Master master) {
        int n = words.length;

        // H[i][j] 为 wordlist[i] 和 wordlist[j] 单词匹配数。
        H = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int match = 0;
                for (int k = 0; k < 6; k++) {
                    if (words[i].charAt(k) == words[j].charAt(k)) {
                        match++;
                    }
                }
                H[i][j] = H[j][i] = match;
            }
        }

        List<Integer> possible = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            possible.add(i);
        }
        while (!possible.isEmpty()) {
            int guess = solve(possible, path);
            int matches = master.guess(words[guess]);
            if (matches == words[0].length()) return;
            List<Integer> possible2 = new ArrayList<>();
            for (Integer j : possible) {
                if (H[guess][j] == matches) {
                    possible2.add(j);
                }
            }
            possible = possible2;
            path.add(guess);
        }
    }

    public int solve(List<Integer> possible, List<Integer> path) {
        if (possible.size() <= 2) return possible.get(0);
        List<Integer> ans_group = possible;
        int ans_guess = -1;
        for (int guess = 0; guess < H.length; ++guess) {
            if (!path.contains(guess)) {
                List<Integer>[] groups = new ArrayList[7];
                for (int i = 0; i < 7; i++) {
                    groups[i] = new ArrayList<>();
                }
                for (Integer j : possible) {
                    if (j != guess) {
                        groups[H[guess][j]].add(j);
                    }
                }
                List<Integer> max_group = groups[0];
                for (int i = 0; i < 7; i++) {
                    if (groups[i].size() > max_group.size()) {
                        max_group = groups[i];
                    }
                }
                if (max_group.size() < ans_group.size()) {
                    ans_group = max_group;
                    ans_guess = guess;
                }
            }
        }
        return ans_guess;
    }

    interface Master {
        int guess(String word);
    }
}
/*
843. 猜猜这个单词
https://leetcode.cn/problems/guess-the-word/description/

给你一个由 不同 字符串组成的单词列表 words ，其中 words[i] 长度均为 6 。words 中的一个单词将被选作秘密单词 secret 。
另给你一个辅助对象 Master ，你可以调用 Master.guess(word) 来猜单词，其中参数 word 长度为 6 且必须是 words 中的字符串。
Master.guess(word) 将会返回如下结果：
- 如果 word 不是 words 中的字符串，返回 -1 ，或者
- 一个整数，表示你所猜测的单词 word 与 秘密单词 secret 的准确匹配（值和位置同时匹配）的数目。
每组测试用例都会包含一个参数 allowedGuesses ，其中 allowedGuesses 是你可以调用 Master.guess(word) 的最大次数。
对于每组测试用例，在不超过允许猜测的次数的前提下，你应该调用 Master.guess 来猜出秘密单词。最终，你将会得到以下结果：
- 如果你调用 Master.guess 的次数大于 allowedGuesses 所限定的次数或者你没有用 Master.guess 猜到秘密单词，则得到 "Either you took too many guesses, or you did not find the secret word." 。
- 如果你调用 Master.guess 猜到秘密单词，且调用 Master.guess 的次数小于或等于 allowedGuesses ，则得到 "You guessed the secret word correctly." 。
生成的测试用例保证你可以利用某种合理的策略（而不是暴力）猜到秘密单词。
提示：
1 <= words.length <= 100
words[i].length == 6
words[i] 仅由小写英文字母组成
words 中所有字符串 互不相同
secret 存在于 words 中
10 <= allowedGuesses <= 30

启发式极小化极大算法
https://oi-wiki.org/search/alpha-beta/
 */