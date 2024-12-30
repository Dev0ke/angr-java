import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP244 {
    static class WordDistance {
        private final Map<String, List<Integer>> idxListMap;

        public WordDistance(String[] wordsDict) {
            idxListMap = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                idxListMap.computeIfAbsent(wordsDict[i], key -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> idxList1 = idxListMap.get(word1);
            List<Integer> idxList2 = idxListMap.get(word2);
            int p1 = 0;
            int p2 = 0;
            int min = Integer.MAX_VALUE;
            while (p1 < idxList1.size() && p2 < idxList2.size()) {
                int idx1 = idxList1.get(p1);
                int idx2 = idxList2.get(p2);
                min = Math.min(min, Math.abs(idx1 - idx2));
                if (idx1 < idx2) {
                    p1++;
                } else {
                    p2++;
                }
            }
            return min;
        }
    }
}
/*
$244. 最短单词距离 II
https://leetcode.cn/problems/shortest-word-distance-ii/

请设计一个类，使该类的构造函数能够接收一个字符串数组。然后再实现一个方法，该方法能够分别接收两个单词，并返回列表中这两个单词之间的最短距离。
实现 WordDistanc 类:
- WordDistance(String[] wordsDict) 用字符串数组 wordsDict 初始化对象。
- int shortest(String word1, String word2) 返回数组 worddict 中 word1 和 word2 之间的最短距离。
注意:
1 <= wordsDict.length <= 3 * 10^4
1 <= wordsDict[i].length <= 10
wordsDict[i] 由小写英文字母组成
word1 和 word2 在数组 wordsDict 中
word1 != word2
shortest 操作次数不大于 5000

HashMap + 双指针
 */