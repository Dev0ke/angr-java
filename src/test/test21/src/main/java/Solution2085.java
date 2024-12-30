import java.util.HashMap;
import java.util.Map;

public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> cntMap1 = new HashMap<>();
        for (String word : words1) {
            cntMap1.put(word, cntMap1.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> cntMap2 = new HashMap<>();
        for (String word : words2) {
            cntMap2.put(word, cntMap2.getOrDefault(word, 0) + 1);
        }
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : cntMap1.entrySet()) {
            if (entry.getValue() == 1 && cntMap2.getOrDefault(entry.getKey(), 0) == 1) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2085. 统计出现过一次的公共字符串
https://leetcode.cn/problems/count-common-words-with-one-occurrence/

第 66 场双周赛 T1。

给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。

HashMap 统计频次即可。
 */