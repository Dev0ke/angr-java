import java.util.BitSet;

public class SolutionP758 {
    private static final String BOLD_START = "<b>";
    private static final String BOLD_END = "</b>";

    public String boldWords(String[] words, String s) {
        int len = s.length();
        BitSet bitSet = new BitSet(len);
        for (String word : words) {
            int idx = s.indexOf(word);
            while (idx >= 0) {
                bitSet.set(idx, idx + word.length());
                idx = s.indexOf(word, idx + 1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (bitSet.get(i) && (i == 0 || !bitSet.get(i - 1))) {
                stringBuilder.append(BOLD_START);
            }
            stringBuilder.append(s.charAt(i));
            if (bitSet.get(i) && (i == len - 1 || !bitSet.get(i + 1))) {
                stringBuilder.append(BOLD_END);
            }
        }
        return stringBuilder.toString();
    }
}
/*
$758. 字符串中的加粗单词
https://leetcode.cn/problems/bold-words-in-string/

给定一个关键词集合 words 和一个字符串 s，将所有 s 中出现的关键词 words[i] 加粗。所有在标签 <b> 和 <b> 中的字母都会加粗。
加粗后返回 s 。返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
提示:
1 <= s.length <= 500
0 <= words.length <= 50
1 <= words[i].length <= 10
s 和 words[i] 由小写英文字母组成

同: $616. 给字符串添加加粗标签
https://leetcode.cn/problems/add-bold-tag-in-string/
 */