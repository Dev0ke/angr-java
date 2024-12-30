public class Solution1410 {
    public String entityParser(String text) {
        return text
                .replace("&quot;", "\"")
                .replace("&apos;", "'")
                .replace("&gt;", ">")
                .replace("&lt;", "<")
                .replace("&frasl;", "/")
                .replace("&amp;", "&");
    }

    private static final String[][] MP = new String[][]{
            {"&quot;", "\""},
            {"&apos;", "'"},
            {"&amp;", "&"},
            {"&gt;", ">"},
            {"&lt;", "<"},
            {"&frasl;", "/"}
    };

    public String entityParser2(String text) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < text.length(); ) {
            boolean match = false;
            if (text.charAt(i) == '&') {
                for (String[] p : MP) {
                    String k = p[0], v = p[1];
                    // if (text.substring(i, i + k.length()).equals(k)) {
                    if (text.startsWith(k, i)) {
                        ans.append(v);
                        i += k.length();
                        match = true;
                        break;
                    }
                }
            }
            if (!match) {
                ans.append(text.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}
/*
1410. HTML 实体解析器
https://leetcode.cn/problems/html-entity-parser/description/

「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
HTML 里这些特殊字符和它们对应的字符实体包括：
- 双引号：字符实体为 &quot; ，对应的字符是 " 。
- 单引号：字符实体为 &apos; ，对应的字符是 ' 。
- 与符号：字符实体为 &amp; ，对应对的字符是 & 。
- 大于号：字符实体为 &gt; ，对应的字符是 > 。
- 小于号：字符实体为 &lt; ，对应的字符是 < 。
- 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
提示：
1 <= text.length <= 10^5
字符串可能包含 256 个ASCII 字符中的任意字符。

枚举。替换。
时间复杂度 O(kn)。其中 k 为实体字符总长度。
空间复杂度 O(k)。
 */