public class Solution1839 {
    private static final char[][] TRANSIT = {
            {'a', 'e'}, {'e', 'i'}, {'i', 'o'}, {'o', 'u'},
            {'a', 'a'}, {'e', 'e'}, {'i', 'i'}, {'o', 'o'}, {'u', 'u'},
            {'x', 'a'}, {'e', 'a'}, {'i', 'a'}, {'o', 'a'}, {'u', 'a'}
    };

    private boolean find(char state, int ch) {
        for (char[] chars : TRANSIT) {
            if (chars[0] == state && chars[1] == ch) {
                return true;
            }
        }
        return false;
    }

    public int longestBeautifulSubstring(String word) {
        int cnt = 0, max = 0;
        char state = 'x';
        for (char ch : word.toCharArray()) {
            if (find(state, ch)) {
                if (state != 'a' && ch == 'a') {
                    cnt = 0;
                }
                cnt++;
                state = ch;
            } else {
                cnt = 0;
                state = 'x';
            }
            if (state == 'u') {
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
/*
1839. 所有元音按顺序排布的最长子字符串
https://leetcode.cn/problems/longest-substring-of-all-vowels-in-order/

当一个字符串满足如下条件时，我们称它是 美丽的 ：
- 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
- 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
子字符串 是字符串中一个连续的字符序列。
提示：
1 <= word.length <= 5 * 10^5
word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。

自动机/状态机
时间复杂度 O(n)
相似题目: 674. 最长连续递增序列
https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
1003. 检查替换后的词是否有效
https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/description/
 */