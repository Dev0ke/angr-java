public class Solution1347 {
    public int minSteps(String s, String t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int ans = 0;
        for (char c : t.toCharArray()) {
            if (cnt[c - 'a'] > 0) cnt[c - 'a']--;
            else ans++;
        }
        return ans;
    }
}
/*
1347. 制造字母异位词的最小步骤数
https://leetcode.cn/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/

给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
返回使 t 成为 s 的字母异位词的最小步骤数。
字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
提示：
1 <= s.length <= 50000
s.length == t.length
s 和 t 只包含小写英文字母

遍历。
时间复杂度 O(n)。
 */