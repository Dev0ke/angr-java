public class Solution3120 {
    public int numberOfSpecialChars(String word) {
        boolean[] lowercase = new boolean[26];
        boolean[] uppercase = new boolean[26];
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase[c - 'a'] = true;
            } else {
                uppercase[c - 'A'] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lowercase[i] && uppercase[i]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3120. 统计特殊字母的数量 I
https://leetcode.cn/problems/count-the-number-of-special-characters-i/description/

第 394 场周赛 T1。

给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
返回 word 中 特殊字母 的数量。
提示：
1 <= word.length <= 50
word 仅由小写和大写英文字母组成。

枚举。
时间复杂度 O(n)。
 */