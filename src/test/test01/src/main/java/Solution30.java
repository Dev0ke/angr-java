import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        // 统计
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.getOrDefault(word, 0) + 1);
        }

        int M = words.length;
        int N = words[0].length();
        int totalLen = M * N;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < s.length() - totalLen + 1; i++) {
            String tmp = s.substring(i, i + totalLen);
            Map<String, Integer> tmpMap = new HashMap<>();
            for (int j = 0; j < totalLen; j += N) {
                String word = tmp.substring(j, j + N);
                tmpMap.put(word, tmpMap.getOrDefault(word, 0) + 1);
            }
            if (cntMap.equals(tmpMap)) {
                resList.add(i);
            }
        }
        return resList;
    }
}
/*
30. 串联所有单词的子串
https://leetcode.cn/problems/substring-with-concatenation-of-all-words/

给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
- 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
"acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
返回所有串联字串在 s 中的开始索引。你可以以 任意顺序 返回答案。
提示：
1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] 和 s 由小写英文字母组成

因为长度相同的单词 words，所以子串长度是定值 words.length * words[i].length
枚举这个定制长度的子串，再利用 HashMap 进行判等
 */