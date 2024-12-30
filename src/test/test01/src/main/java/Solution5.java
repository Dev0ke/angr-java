import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    // 动态规划 时间复杂度 O(n^2)
    public String longestPalindrome(String s) {
        // 长度 0 和 1
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 记录答案开始下标与最大长度
        int resLen = 1;
        int resBegin = 0;

        char[] chars = s.toCharArray();
        // 注意此处 left <= len
        for (int left = 2; left <= len; left++) {
            for (int i = 0; i < len; i++) {
                int j = left + i - 1;
                if (j >= len) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 转移方程
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 刷新最大值
                if (dp[i][j] && j - i + 1 > resLen) {
                    resLen = j - i + 1;
                    resBegin = i;
                }
            }
        }
        return s.substring(resBegin, resBegin + resLen);
    }

    // Manacher 算法 时间复杂度 O(n)
    public String longestPalindrome2(String s) {
        // 填充字符 '#' (统一处理长度为奇数)
        // aaba => #a#a#b#a#
        // aba => #a#b#a#
        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append('#');
        }
        s = stringBuilder.toString();

        // 臂长
        List<Integer> armLen = new ArrayList<>();
        int start = 0;
        int end = -1;
        int right = -1;
        int j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int curArmLen;
            if (right >= i) {
                int iSym = j * 2 - i;
                int minArmLen = Math.min(armLen.get(iSym), right - i);
                curArmLen = expand(s, i - minArmLen, i + minArmLen);
            } else {
                curArmLen = expand(s, i, i);
            }
            armLen.add(curArmLen);
            if (i + curArmLen > right) {
                j = i;
                right = i + curArmLen;
            }
            if (curArmLen * 2 + 1 > end - start) {
                start = i - curArmLen;
                end = i + curArmLen;
            }
        }

        // 去掉填充字符后的答案
        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
}
/*
5. 最长回文子串
https://leetcode.cn/problems/longest-palindromic-substring/

给你一个字符串 s，找到 s 中最长的回文子串。
提示：
1 <= s.length <= 1000
s 仅由数字和英文字母组成

动态规划/Manacher 马拉车算法
官方题解: https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 */