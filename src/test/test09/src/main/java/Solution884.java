import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> cntMap = new HashMap<>();
        for (String str : s1.split(" ")) {
            cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
        }
        for (String str : s2.split(" ")) {
            cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                resList.add(entry.getKey());
            }
        }
        return resList.toArray(String[]::new);
    }
}
/*
884. 两句话中的不常见单词
https://leetcode.cn/problems/uncommon-words-from-two-sentences/

第 97 场周赛 T1。

句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
提示：
1 <= s1.length, s2.length <= 200
s1 和 s2 由小写英文字母和空格组成
s1 和 s2 都不含前导或尾随空格
s1 和 s2 中的所有单词间均由单个空格分隔

使用一个 HashMap 统计两个句子单词频次即可。频次为 1 单词即为 "不常见单词"
 */