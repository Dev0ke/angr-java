import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();

        List<String> resList = new ArrayList<>();
        if (len < 10) {
            return resList;
        }

        Map<String, Integer> cntMap = new HashMap<>();
        for (int i = 0; i + 10 <= len; i++) {
            String str = s.substring(i, i + 10);
            cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
            if (cntMap.get(str) == 2) {
                resList.add(str);
            }
        }
        return resList;
    }
}
/*
187. 重复的DNA序列
https://leetcode.cn/problems/repeated-dna-sequences/

DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
- 例如，"ACGAATTCCG" 是一个 DNA序列 。
在研究 DNA 时，识别 DNA 中的重复序列非常有用。
给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
提示：
0 <= s.length <= 10^5
s[i]=='A'、'C'、'G' or 'T'

HashMap 统计频次即可。
 */