import java.util.Locale;

public class Solution748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCnt = cntCh(licensePlate.toLowerCase(Locale.ENGLISH));
        String res = "";
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            if (check(licensePlateCnt, cntCh(word)) && word.length() < minLen) {
                minLen = word.length();
                res = word;
            }
        }
        return res;
    }

    private int[] cntCh(String str) {
        int[] cnt = new int[26];
        for (char ch : str.toCharArray()) {
            int idx = ch - 'a';
            if (idx >= 0 && idx < 26) {
                cnt[ch - 'a']++;
            }
        }
        return cnt;
    }

    private boolean check(int[] cnt1, int[] cnt2) {
        // 期望 cnt1 <= cnt2
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
748. 最短补全词
https://leetcode.cn/problems/shortest-completing-word/

给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出 words 中的 最短补全词 。
补全词 是一个包含 licensePlate 中所有字母的单词。忽略 licensePlate 中的 数字和空格 。不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
提示：
1 <= licensePlate.length <= 7
licensePlate 由数字、大小写字母或空格 ' ' 组成
1 <= words.length <= 1000
1 <= words[i].length <= 15
words[i] 由小写英文字母组成

长度为 26 整型数组统计字符频次即可。
 */