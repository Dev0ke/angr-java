import java.util.HashMap;
import java.util.Map;

public class Solution1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        char[] chars = s.toCharArray();

        Map<String, Integer> strCntMap = new HashMap<>();
        // 逐个长度 滑窗
        for (int k = minSize; k <= maxSize; k++) {
            Map<Character, Integer> chCntMap = new HashMap<>();
            // [0, k)
            for (int i = 0; i < k; i++) {
                chCntMap.put(chars[i], chCntMap.getOrDefault(chars[i], 0) + 1);
            }
            if (chCntMap.size() <= maxLetters) {
                String sub = s.substring(0, k);
                strCntMap.put(sub, strCntMap.getOrDefault(sub, 0) + 1);
            }
            // [k, n)
            for (int i = k; i < n; i++) {
                chCntMap.put(chars[i], chCntMap.getOrDefault(chars[i], 0) + 1);
                char rm = chars[i - k];
                int cnt = chCntMap.get(rm);
                if (cnt == 1) {
                    chCntMap.remove(rm);
                } else {
                    chCntMap.put(rm, cnt - 1);
                }
                if (chCntMap.size() <= maxLetters) {
                    String sub = s.substring(i - k + 1, i + 1);
                    strCntMap.put(sub, strCntMap.getOrDefault(sub, 0) + 1);
                }
            }
        }

        return strCntMap.values().stream().max(Integer::compareTo).orElse(0);
    }
}
/*
1297. 子串的最大出现次数
https://leetcode.cn/problems/maximum-number-of-occurrences-of-a-substring/

给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
- 子串中不同字母的数目必须小于等于 maxLetters 。
- 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
提示：
1 <= s.length <= 10^5
1 <= maxLetters <= 26
1 <= minSize <= maxSize <= min(26, s.length)
s 只包含小写英文字母。

时间复杂度 O(n * (maxSize-minSize)) 常数
 */