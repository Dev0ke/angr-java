public class Solution1309 {
    private static final String[][] MAPPING1 = {
            {"a", "1"}, {"b", "2"}, {"c", "3"}, {"d", "4"}, {"e", "5"}, {"f", "6"}, {"g", "7"}, {"h", "8"}, {"i", "9"}
    };

    private static final String[][] MAPPING2 = {
            {"j", "10#"}, {"k", "11#"}, {"l", "12#"}, {"m", "13#"}, {"n", "14#"}, {"o", "15#"},
            {"p", "16#"}, {"q", "17#"}, {"r", "18#"}, {"s", "19#"}, {"t", "20#"}, {"u", "21#"},
            {"v", "22#"}, {"w", "23#"}, {"x", "24#"}, {"y", "25#"}, {"z", "26#"},
    };

    public String freqAlphabets(String s) {
        for (String[] map : MAPPING2) {
            s = s.replace(map[1], map[0]);
        }
        for (String[] map : MAPPING1) {
            s = s.replace(map[1], map[0]);
        }
        return s;
    }
}
/*
1309. 解码字母到整数映射
https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping/

给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
- 字符（'a' - 'i'）分别用（'1' - '9'）表示。
- 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
返回映射之后形成的新字符串。
题目数据保证映射始终唯一。
提示：
1 <= s.length <= 1000
s[i] 只包含数字（'0'-'9'）和 '#' 字符。
s 是映射始终存在的有效字符串。

String#replace
 */