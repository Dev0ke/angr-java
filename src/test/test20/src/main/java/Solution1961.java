public class Solution1961 {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        int sLen = s.length();
        for (String word : words) {
            int len = word.length();
            // 防止越界
            int curLen = i + len;
            if (curLen <= sLen && s.substring(i, curLen).equals(word)) {
                i = curLen;
                // 完全匹配时结束
                if (i == sLen) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
/*
1961. 检查字符串是否为数组前缀
https://leetcode.cn/problems/check-if-string-is-a-prefix-of-array/

第 253 场周赛 T1。

给你一个字符串 s 和一个字符串数组 words ，请你判断 s 是否为 words 的 前缀字符串 。
字符串 s 要成为 words 的 前缀字符串 ，需要满足：s 可以由 words 中的前 k（k 为 正数 ）个字符串按顺序相连得到，且 k 不超过 words.length 。
如果 s 是 words 的 前缀字符串 ，返回 true ；否则，返回 false 。
提示：
1 <= words.length <= 100
1 <= words[i].length <= 20
1 <= s.length <= 1000
words[i] 和 s 仅由小写英文字母组成

根据题意进行模拟。只有长度刚好相等时才是前缀字符串。小于或者大于都返回 false。
 */