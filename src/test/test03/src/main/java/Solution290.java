import java.util.HashMap;
import java.util.Map;

public class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        int len1 = pattern.length();
        int len2 = ss.length;
        if (len1 != len2) {
            return false;
        }
        Map<Character, String> chStrMap = new HashMap<>();
        Map<String, Character> strChMap = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            // char => String
            if (!chStrMap.containsKey(pattern.charAt(i))) {
                chStrMap.put(pattern.charAt(i), ss[i]);
            } else {
                if (!chStrMap.get(pattern.charAt(i)).equals(ss[i])) {
                    return false;
                }
            }
            // String => char
            if (!strChMap.containsKey(ss[i])) {
                strChMap.put(ss[i], pattern.charAt(i));
            } else {
                if (!strChMap.get(ss[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
290. 单词规律
https://leetcode.cn/problems/word-pattern/

给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
提示:
1 <= pattern.length <= 300
pattern 只包含小写英文字母
1 <= s.length <= 3000
s 只包含小写英文字母和 ' '
s 不包含 任何前导或尾随对空格
s 中每个单词都被 单个空格 分隔

两个 HashMap 分别记录 pattern => str, str => pattern 的映射关系。从左往右变量判断即可。
时间复杂度 O(n)
 */