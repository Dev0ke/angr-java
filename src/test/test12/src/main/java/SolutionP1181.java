import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionP1181 {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int n = phrases.length;
        String[][] sp = new String[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = phrases[i].split(" ");
            sp[i] = new String[]{s[0], s[s.length - 1]};
        }
        Set<String> m = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (sp[i][0].equals(sp[j][1])) {
                    m.add(phrases[j] + phrases[i].substring(sp[i][0].length()));
                }
            }
        }
        List<String> ret = new ArrayList<>(m);
        Collections.sort(ret);
        return ret;
    }
}
/*
$1181. 前后拼接
https://leetcode.cn/problems/before-and-after-puzzle/

给你一个「短语」列表 phrases，请你帮忙按规则生成拼接后的「新短语」列表。
「短语」（phrase）是仅由小写英文字母和空格组成的字符串。「短语」的开头和结尾都不会出现空格，「短语」中的空格不会连续出现。
「前后拼接」（Before and After puzzles）是合并两个「短语」形成「新短语」的方法。我们规定拼接时，第一个短语的最后一个单词 和 第二个短语的第一个单词 必须相同。
返回每两个「短语」 phrases[i] 和 phrases[j]（i != j）进行「前后拼接」得到的「新短语」。
注意，两个「短语」拼接时的顺序也很重要，我们需要同时考虑这两个「短语」。另外，同一个「短语」可以多次参与拼接，但「新短语」不能再参与拼接。
请你按字典序排列并返回「新短语」列表，列表中的字符串应该是 不重复的 。
提示：
1 <= phrases.length <= 100
1 <= phrases[i].length <= 100

哈希表 + 排序
 */