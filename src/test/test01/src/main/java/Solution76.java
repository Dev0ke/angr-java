import java.util.HashMap;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m) return "";

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.merge(c, 1, Integer::sum);
        }
        int l = 0, r = 0;
        int minPos = -1;
        int minLen = n + 1;
        while (r < n) {
            sMap.merge(s.charAt(r), 1, Integer::sum);
            while (check(sMap, tMap)) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    minPos = l;
                }
                sMap.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            r++;
        }
        return minPos == -1 ? "" : s.substring(minPos, minPos + minLen);
    }

    private boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
/*
76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/

给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：
- 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
- 如果 s 中存在这样的子串，我们保证它是唯一的答案。
提示：
1 <= s.length, t.length <= 10^5
s 和 t 由英文字母组成
进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

不定长滑动窗口（求最短/最小）
这题细节较多。提交到第 10 次才通过，UT 中补充一些用例。
时间复杂度 O(n)
 */