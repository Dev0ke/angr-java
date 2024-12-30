import java.util.BitSet;

public class SolutionP616 {
    private static final String BOLD_START = "<b>";
    private static final String BOLD_END = "</b>";

    public String addBoldTag(String s, String[] words) {
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
$616. 给字符串添加加粗标签
https://leetcode.cn/problems/add-bold-tag-in-string/

给你一个字符串 s 和一个字符串列表 words ，你需要将在字符串列表中出现过的 s 的子串添加加粗闭合标签 <b> 和 </b> 。
如果两个子串有重叠部分，你需要把它们一起用一对闭合标签包围起来。同理，如果两个子字符串连续被加粗，那么你也需要把它们合起来用一对加粗标签包围。
返回添加加粗标签后的字符串 s 。
提示：
1 <= s.length <= 1000
0 <= words.length <= 100
1 <= words[i].length <= 1000
s 和 words[i] 由英文字母和数字组成
words 中的所有值 互不相同

同: $758. 字符串中的加粗单词
https://leetcode.cn/problems/bold-words-in-string/
 */