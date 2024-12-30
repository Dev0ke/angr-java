public class Solution2068 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        // 长度 26 数组模拟 字典
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];
        for (char ch : word1.toCharArray()) {
            dict1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            dict2[ch - 'a']++;
        }
        // 逐个字母频次比较
        for (int i = 0; i < 26; i++) {
            if (Math.abs(dict1[i] - dict2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
/*
2068. 检查两个字符串是否几乎相等
https://leetcode.cn/problems/check-whether-two-strings-are-almost-equivalent/

第 65 场双周赛 T1。

如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，那么我们称这两个字符串 word1 和 word2 几乎相等 。
给你两个长度都为 n 的字符串 word1 和 word2 ，如果 word1 和 word2 几乎相等 ，请你返回 true ，否则返回 false 。
一个字母 x 的出现 频率 指的是它在字符串中出现的次数。

模拟。逐个字母比较频次即可。
 */