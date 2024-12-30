import java.util.Set;
import java.util.stream.Collectors;

public class Solution1704 {
    public boolean halvesAreAlike(String s) {
        int halfLen = s.length() / 2;

        String vowels = "aeiouAEIOU";
        Set<Character> set = vowels.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < halfLen; i++) {
            if (set.contains(s.charAt(i))) {
                cnt1++;
            }
            if (set.contains(s.charAt(i + halfLen))) {
                cnt2++;
            }
        }
        return cnt1 == cnt2;
    }
}
/*
1704. 判断字符串的两半是否相似
https://leetcode.cn/problems/determine-if-string-halves-are-alike/

给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
如果 a 和 b 相似，返回 true ；否则，返回 false 。
提示：
2 <= s.length <= 1000
s.length 是偶数
s 由 大写和小写 字母组成

模拟
 */