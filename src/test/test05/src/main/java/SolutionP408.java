public class SolutionP408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        // 预处理，保证不以数字结尾
        word = word + "$";
        abbr = abbr + "$";
        int len1 = word.length();
        int len2 = abbr.length();

        // 双指针
        int p1 = 0;
        int p2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (p1 < len1 && p2 < len2) {
            char ch = abbr.charAt(p2);

            // 不合法的缩写
            if (ch == '0' && stringBuilder.isEmpty()) {
                return false;
            }
            // 数字
            if (Character.isDigit(ch)) {
                stringBuilder.append(ch - '0');
                p2++;
            }
            // 字母
            else {
                // 不存在缩写
                if (stringBuilder.isEmpty()) {
                    if (word.charAt(p1) == ch) {
                        p1++;
                        p2++;
                    } else {
                        return false;
                    }
                }
                // 存在缩写
                else {
                    int abbrLen = Integer.parseInt(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                    p1 += abbrLen;
                }
            }
        }
        return p1 == len1 && p2 == len2;
    }
}
/*
$408. 有效单词缩写
https://leetcode.cn/problems/valid-word-abbreviation/

字符串可以用 缩写 进行表示，缩写 的方法是将任意数量的 不相邻 的子字符串替换为相应子串的长度。例如，字符串 "substitution" 可以缩写为（不止这几种方法）：
- "s10n" ("s ubstitutio n")
- "sub4u4" ("sub stit u tion")
- "12" ("substitution")
- "su3i1u2on" ("su bst i t u ti on")
- "substitution" (没有替换子字符串)
下列是不合法的缩写：
- "s55n" ("s ubsti tutio n"，两处缩写相邻)
- "s010n" (缩写存在前导零)
- "s0ubstitution" (缩写是一个空字符串)
给你一个字符串单词 word 和一个缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
子字符串是字符串中连续的非空字符序列。
提示：
1 <= word.length <= 20
word 仅由小写英文字母组成
1 <= abbr.length <= 10
abbr 由小写英文字母和数字组成
abbr 中的所有数字均符合 32-bit 整数范围

双指针模拟。
 */