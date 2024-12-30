import java.util.ArrayList;
import java.util.List;

public class SolutionP1065 {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> resList = new ArrayList<>();
        for (String word : words) {
            List<Integer> fromIdxList = new ArrayList<>();
            // dfs 结合 indexOf 找出当前 word 所有的开始下标
            helper(text, word, fromIdxList, 0);
            for (int fromIdx : fromIdxList) {
                resList.add(new int[]{fromIdx, fromIdx + word.length() - 1});
            }
        }
        // 排序答案后返回
        resList.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        return resList.toArray(int[][]::new);
    }

    private void helper(String text, String word, List<Integer> list, int fromIndex) {
        int idx = text.indexOf(word, fromIndex);
        if (idx != -1) {
            list.add(idx);
            helper(text, word, list, idx + 1);
        }
    }
}
/*
$1065. 字符串的索引对
https://leetcode.cn/problems/index-pairs-of-a-string/

第 1 场双周赛 T2。

给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j]
使得在索引对范围内的子字符串 text[i]...text[j]（包括 i 和 j）属于字符串列表 words。
提示:
所有字符串都只包含小写字母。
保证 words 中的字符串无重复。
1 <= text.length <= 100
1 <= words.length <= 20
1 <= words[i].length <= 50
按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。

dfs 结合 indexOf 找出当前 word 所有的开始下标
 */