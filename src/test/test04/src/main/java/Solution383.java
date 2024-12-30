import java.util.HashMap;
import java.util.Map;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cntMap1 = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            cntMap1.put(ch, cntMap1.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> cntMap2 = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            cntMap2.put(ch, cntMap2.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : cntMap1.entrySet()) {
            char key = entry.getKey();
            if (!cntMap2.containsKey(key) || cntMap2.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
/*
383. 赎金信
https://leetcode.cn/problems/ransom-note/

给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。
提示：
1 <= ransomNote.length, magazine.length <= 10^5
ransomNote 和 magazine 由小写英文字母组成

HashMap 统计频次即可。
 */