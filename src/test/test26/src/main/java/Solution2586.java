public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i])) {
                res++;
            }
        }
        return res;
    }

    private boolean isVowel(String s) {
        int n = s.length();
        char c1 = s.charAt(0);
        char c2 = s.charAt(n - 1);
        return "aeiou".indexOf(c1) >= 0 && "aeiou".indexOf(c2) >= 0;
    }
}
/*
2586. 统计范围内的元音字符串数
https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/

第 336 场周赛 T1。

给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
提示：
1 <= words.length <= 1000
1 <= words[i].length <= 10
words[i] 仅由小写英文字母组成
0 <= left <= right < words.length

模拟。
 */