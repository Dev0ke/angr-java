public class Solution3136 {
    public boolean isValid(String word) {
        char[] s = word.toCharArray();
        if (s.length < 3) return false;
        boolean has_vowel = false, has_consonant = false;
        for (char c : s) {
            if (c == '@' || c == '#' || c == '$') return false;
            if (Character.isLetter(c)) {
                if (isVowel(c)) has_vowel = true;
                else has_consonant = true;
            }
        }
        return has_vowel && has_consonant;
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
/*
3136. 有效单词
https://leetcode.cn/problems/valid-word/description/

第 396 场周赛 T1。

有效单词 需要满足以下几个条件：
- 至少 包含 3 个字符。
- 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
- 至少 包含一个 元音字母 。
- 至少 包含一个 辅音字母 。
给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
注意：
- 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
- 英文中的 辅音字母 是指那些除元音字母之外的字母。
提示：
1 <= word.length <= 20
word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。

模拟。
时间复杂度 O(n)
 */