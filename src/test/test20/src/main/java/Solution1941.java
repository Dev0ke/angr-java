import java.util.HashMap;
import java.util.Map;

public class Solution1941 {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        if (cntMap.size() == 1) {
            return true;
        }
        int cnt = cntMap.get(s.charAt(0));
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() != cnt) {
                return false;
            }
        }
        return true;
    }
}
/*
1941. 检查是否所有字符出现次数相同
https://leetcode.cn/problems/check-if-all-characters-have-equal-number-of-occurrences/

第 57 场双周赛 T1。

给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
提示：
1 <= s.length <= 1000
s 只包含小写英文字母。

统计字符串各字符频次后比较即可。
 */