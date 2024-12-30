import java.util.HashSet;
import java.util.Set;

public class Solution2309 {
    public String greatestLetter(String s) {
        Set<Character> hashSet = new HashSet<>();
        for (char ch : s.toCharArray()) {
            hashSet.add(ch);
        }

        for (char ch = 'Z'; ch >= 'A'; ch--) {
            if (hashSet.contains(ch) && hashSet.contains(Character.toLowerCase(ch))) {
                return String.valueOf(ch);
            }
        }
        return "";
    }
}
/*
2309. 兼具大小写的最好英文字母
https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/

第 298 场周赛 T1。

给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
最好 英文字母的大写和小写形式必须 都 在 s 中出现。
英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
提示：
1 <= s.length <= 1000
s 由小写和大写英文字母组成

模拟。
 */