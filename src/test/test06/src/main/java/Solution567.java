import java.util.Arrays;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        // 特判
        if (s1.length() > s2.length()) return false;

        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        // 判断 s 的 排列之一是 t 的子串
        int[] cnt1 = new int[26], cnt2 = new int[26];
        // 窗口大小
        int k = s.length;
        for (int i = 0; i < k; i++) {
            cnt1[s[i] - 'a']++;
            cnt2[t[i] - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = k; i < t.length; i++) {
            cnt2[t[i - k] - 'a']--;
            cnt2[t[i] - 'a']++;
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}
/*
567. 字符串的排列
https://leetcode.cn/problems/permutation-in-string/

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。
提示：
1 <= s1.length, s2.length <= 10^4
s1 和 s2 仅包含小写字母

定长滑动窗口。
时间复杂度 O(n)
相似题目: 438. 找到字符串中所有字母异位词
https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */