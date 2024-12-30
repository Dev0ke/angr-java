import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SolutionP245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        // 预处理
        List<Integer> idxList = new ArrayList<>();
        TreeSet<Integer> idxTreeSet = new TreeSet<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idxList.add(i);
            } else if (wordsDict[i].equals(word2)) {
                idxTreeSet.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 1; i < idxList.size(); i++) {
                min = Math.min(min, idxList.get(i) - idxList.get(i - 1));
            }
            return min;
        }
        // solution243
        for (Integer idx : idxList) {
            Integer floor = idxTreeSet.floor(idx);
            if (floor != null) {
                min = Math.min(min, idx - floor);
            }
            Integer ceiling = idxTreeSet.ceiling(idx);
            if (ceiling != null) {
                min = Math.min(min, ceiling - idx);
            }
        }
        return min;
    }
}
/*
$245. 最短单词距离 III
https://leetcode.cn/problems/shortest-word-distance-iii/

给定一个字符串数组 wordsDict 和两个字符串 word1 和 word2 ，返回列表中这两个单词之间的最短距离。
注意：word1 和 word2 是有可能相同的，并且它们将分别表示为列表中 两个独立的单词 。
提示：
1 <= wordsDict.length <= 10^5
1 <= wordsDict[i].length <= 10
wordsDict[i] 由小写英文字母组成
word1 和 word2 都在 wordsDict 中

243 题基础上判断相同情况
相似题目: $243. 最短单词距离
https://leetcode.cn/problems/shortest-word-distance/
 */