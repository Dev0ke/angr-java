import java.util.Locale;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        String subString = word.substring(1);
        if (subString.equals(subString.toLowerCase(Locale.ENGLISH))) {
            return true;
        }
        return subString.equals(subString.toUpperCase(Locale.ENGLISH)) && Character.isUpperCase(word.charAt(0));
    }
}
/*
520. 检测大写字母
https://leetcode.cn/problems/detect-capital/

我们定义，在以下情况时，单词的大写用法是正确的：
- 全部字母都是大写，比如 "USA" 。
- 单词中所有字母都不是大写，比如 "leetcode" 。
- 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
提示：
1 <= word.length <= 100
word 由小写和大写英文字母组成

字符串判等。
 */