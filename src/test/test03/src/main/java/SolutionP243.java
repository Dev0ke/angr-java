import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SolutionP243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
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

        // 最小值
        int min = Integer.MAX_VALUE;
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
$243. 最短单词距离
https://leetcode.cn/problems/shortest-word-distance/

给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
提示:
1 <= wordsDict.length <= 3 * 10^4
1 <= wordsDict[i].length <= 10
wordsDict[i] 由小写英文字母组成
word1 和 word2 在 wordsDict 中
word1 != word2

TreeSet 优化时间复杂度到 O(nlogn)
 */