import java.util.HashMap;
import java.util.Map;

public class Solution409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        // 1 单 + 全 双
        boolean odd = false;
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odd = true;
            }
            cnt += entry.getValue() / 2 * 2;
        }
        if (odd) {
            cnt += 1;
        }
        return cnt;
    }
}
/*
409. 最长回文串
https://leetcode.cn/problems/longest-palindrome/

给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
提示:
1 <= s.length <= 2000
s 只能由小写和/或大写英文字母组成

相似题目: 1400. 构造 K 个回文字符串
https://leetcode.cn/problems/construct-k-palindrome-strings/
 */