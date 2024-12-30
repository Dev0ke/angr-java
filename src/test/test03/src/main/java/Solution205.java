import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        // s[i] => t[i]
        Map<Character, Character> stMap = new HashMap<>();
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (!stMap.containsKey(si) && !hashSet.contains(ti)) {
                stMap.put(si, ti);
                hashSet.add(ti);
            } else {
                // 除了 stMap.containsKey(si) && stMap.get(si) == ti
                if (!stMap.containsKey(si) || stMap.get(si) != ti) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
205. 同构字符串
https://leetcode.cn/problems/isomorphic-strings/

给定两个字符串 s 和 t ，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
提示：
1 <= s.length <= 5 * 10^4
t.length == s.length
s 和 t 由任意有效的 ASCII 字符组成

时间复杂度 O(n)
空间复杂度 O(n)
 */