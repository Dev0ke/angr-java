public class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2185. 统计包含给定前缀的字符串
https://leetcode.cn/problems/counting-words-with-a-given-prefix/

第 282 场周赛 T1。

给你一个字符串数组 words 和一个字符串 pref 。
返回 words 中以 pref 作为 前缀 的字符串的数目。
字符串 s 的 前缀 就是  s 的任一前导连续字符串。
提示：
1 <= words.length <= 100
1 <= words[i].length, pref.length <= 100
words[i] 和 pref 由小写英文字母组成

直接统计。
时间复杂度 O(n*k) 其中 n = words.length，k = pref.length
 */