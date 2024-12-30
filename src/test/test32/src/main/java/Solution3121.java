import java.util.Arrays;

public class Solution3121 {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] upper_first = new int[26];
        Arrays.fill(upper_first, -1);
        int[] lower_last = new int[26];
        Arrays.fill(lower_last, n);
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lower_last[c - 'a'] = i;
            } else {
                if (upper_first[c - 'A'] == -1) {
                    upper_first[c - 'A'] = i;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (lower_last[i] < upper_first[i]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3121. 统计特殊字母的数量 II
https://leetcode.cn/problems/count-the-number-of-special-characters-ii/description/

第 394 场周赛 T2。

给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
返回 word 中 特殊字母 的数量。
提示：
1 <= word.length <= 2 * 10^5
word 仅由小写和大写英文字母组成。

枚举。
时间复杂度 O(n)。
 */