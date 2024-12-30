import java.util.HashSet;
import java.util.Set;

public class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> charSet = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            charSet.add(ch);
        }

        int res = 0;
        for (String word : words) {
            if (check(charSet, word)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(Set<Character> charSet, String word) {
        for (char ch : word.toCharArray()) {
            if (!charSet.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
/*
1684. 统计一致字符串的数目
https://leetcode.cn/problems/count-the-number-of-consistent-strings/

给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
请你返回 words 数组中 一致字符串 的数目。
提示：
1 <= words.length <= 10^4
1 <= allowed.length <= 26
1 <= words[i].length <= 10
allowed 中的字符 互不相同 。
words[i] 和 allowed 只包含小写英文字母。

模拟
 */