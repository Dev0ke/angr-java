public class Solution2272 {
    public int largestVariance(String s) {
        int maxDiff = 0;
        // 出现次数 最多 的字符
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            // 出现次数 最少 的字符
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                if (ch1 == ch2) {
                    continue;
                }
                // ch1、ch2 出现次数之差
                int diff = 0;
                // ch1、ch2 出现次数之差（包含 ch2 时），初始为负无穷
                int diffWithCh2 = Integer.MIN_VALUE;
                for (char ch : s.toCharArray()) {
                    if (ch == ch1) {
                        diff++;
                        diffWithCh2++;
                    } else if (ch == ch2) {
                        diff--;
                        diffWithCh2 = diff;
                        diff = Math.max(diff, 0);
                    }
                    maxDiff = Math.max(maxDiff, diffWithCh2);
                }
            }
        }
        return maxDiff;
    }
}
/*
2272. 最大波动的子字符串
https://leetcode.cn/problems/substring-with-largest-variance/

第 78 场双周赛 T4。

字符串的 波动 定义为子字符串中出现次数 最多 的字符次数与出现次数 最少 的字符次数之差。
给你一个字符串 s ，它只包含小写英文字母。请你返回 s 里所有 子字符串的 最大波动 值。
子字符串 是一个字符串的一段连续字符序列。
提示：
1 <= s.length <= 10^4
s  只包含小写英文字母。

枚举 出现次数 最多/最少 的字符 'ab' 到 'zy'（26 * 25 = 650 个）
 */