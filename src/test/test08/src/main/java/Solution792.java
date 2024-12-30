import java.util.Arrays;

public class Solution792 {
    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();

        // 子序列自动机
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int[][] nxt = new int[n + 1][26];
//        nxt[n] = pos.clone();
        System.arraycopy(pos, 0, nxt[n], 0, 26);
        for (int i = n - 1; i >= 0; i--) {
            pos[s.charAt(i) - 'a'] = i;
//            nxt[i] = pos.clone();
            System.arraycopy(pos, 0, nxt[i], 0, 26);
        }

        int ans = words.length;
        for (String word : words) {
            int pre = 0;
            for (int j = 0; j < word.length(); j++) {
                pre = nxt[pre][word.charAt(j) - 'a'];
                if (pre < 0) {
                    ans--;
                    break;
                }
                pre++;
            }
        }
        return ans;
    }
}
/*
792. 匹配子序列的单词数
https://leetcode.cn/problems/number-of-matching-subsequences/

给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
例如， “ace” 是 “abcde” 的子序列。
提示:
1 <= s.length <= 5 * 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 50
words[i]和 s 都只由小写字母组成。

暴力 时间复杂度 O(n·m·|s|) 其中 n = s.length, m = words.length
考虑二分 时间复杂度 O(logn·m·|s|)
 */