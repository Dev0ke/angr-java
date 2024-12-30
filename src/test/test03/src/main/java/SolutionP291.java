import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionP291 {
    private String pattern;
    private String s;

    public boolean wordPatternMatch(String pattern, String s) {
        this.pattern = pattern;
        this.s = s;
        return dfs(0, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean dfs(int i, int j, Map<Character, String> kvMap, Set<String> valSet) {
        if (i == pattern.length()) {
            return j == s.length();
        }

        // 添加过
        Character key = pattern.charAt(i);
        if (kvMap.containsKey(key)) {
            String val = kvMap.get(key);
            if (j + val.length() <= s.length() && s.startsWith(val, j)) {
                return dfs(i + 1, j + val.length(), kvMap, valSet);
            }
            return false;
        }
        // 未添加过
        for (int k = j + 1; k <= s.length(); k++) {
            String val = s.substring(j, k);
            if (valSet.contains(val)) {
                continue;
            }
            valSet.add(val);
            kvMap.put(key, val);
            if (dfs(i + 1, k, kvMap, valSet)) {
                return true;
            }
            kvMap.remove(key);
            valSet.remove(val);
        }
        return false;
    }
}
/*
$291. 单词规律 II
https://leetcode.cn/problems/word-pattern-ii/

给你一种规律 pattern 和一个字符串 s，请你判断 s 是否和 pattern 的规律相匹配。
如果存在单个字符到字符串的 双射映射 ，那么字符串 s 匹配 pattern ，即：如果pattern 中的每个字符都被它映射到的字符串替换，那么最终的字符串则为 s 。双射 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，也不会存在一个字符分别映射到两个不同的字符串。
提示：
1 <= pattern.length, s.length <= 20
pattern 和 s 由小写英文字母组成

回溯
 */