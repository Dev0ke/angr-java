import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1960 {
    /**
     * 动态规划
     * 时间复杂度 O(n^2) 超出内存限制
     *
     * @param s 下标从 0 开始的字符串 s
     * @return 两个回文子字符串长度的最大乘积
     */
    public long maxProduct(String s) {
        // 2 <= s.length <= 10^5
        int len = s.length();

        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
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
            }
        }
        int maxLen = 1;
        List<int[]> beginEndList = new ArrayList<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            // 剪枝，去掉 i==j
            for (int j = i + 1; j < len; j++) {
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    // 剪枝，去掉偶数长度
                    if (curLen % 2 == 1) {
                        beginEndList.add(new int[]{i, j});
                        // treeMap
                        if (!treeMap.containsKey(i)) {
                            treeMap.put(i, j);
                        } else {
                            int curJ = treeMap.get(i);
                            if (curJ > j) {
                                treeMap.replace(i, curJ);
                            }
                        }
                        if (curLen > maxLen && curLen != len) {
                            maxLen = curLen;
                        }
                    }
                }
            }
        }
        long ans = maxLen;
        for (int[] beginEnd1 : beginEndList) {
            int firstI = beginEnd1[0];
            int firstJ = beginEnd1[1];
            int len1 = firstJ - firstI + 1;
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                int secI = entry.getKey();
                if (secI > firstJ) {
                    int secJ = entry.getValue();
                    int len2 = secJ - secI + 1;
                    ans = Math.max(ans, (long) len1 * len2);
                }
            }
        }
        return ans;
    }

    /**
     * Manacher
     * 时间复杂度 O(n)
     *
     * @param s 下标从 0 开始的字符串 s
     * @return 两个回文子字符串长度的最大乘积
     */
    public long maxProduct2(String s) {
        int n = s.length();
        int[] span = new int[n];

        for (int i = 0, left = 0, right = -1; i < n; i++) {
            span[i] = (i <= right ? Math.min(span[left + right - i], right - i + 1) : 1);
            while (i - span[i] >= 0 && i + span[i] < n && s.charAt(i - span[i]) == s.charAt(i + span[i])) {
                span[i]++;
            }
            if (i + span[i] - 1 > right) {
                left = i - span[i] + 1;
                right = i + span[i] - 1;
            }
        }

        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            int left = i - span[i] + 1;
            int right = i + span[i] - 1;
            pre[right] = Math.max(pre[right], span[i] * 2 - 1);
            suf[left] = Math.max(suf[left], span[i] * 2 - 1);
        }

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i], pre[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            pre[i] = Math.max(pre[i], pre[i + 1] - 2);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i], suf[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            suf[i] = Math.max(suf[i], suf[i - 1] - 2);
        }

        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, (long) pre[i] * suf[i + 1]);
        }
        return ans;
    }
}
/*
1960. 两个回文子字符串长度的最大乘积
https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-substrings/

第 58 场双周赛 T4。

给你一个下标从 0 开始的字符串 s ，你需要找到两个 不重叠的回文 子字符串，它们的长度都必须为 奇数 ，使得它们长度的乘积最大。
更正式地，你想要选择四个整数 i ，j ，k ，l ，使得 0 <= i <= j < k <= l < s.length ，且子字符串 s[i...j] 和 s[k...l] 都是回文串且长度为奇数。
s[i...j] 表示下标从 i 到 j 且 包含 两端下标的子字符串。
请你返回两个不重叠回文子字符串长度的 最大 乘积。
回文字符串 指的是一个从前往后读和从后往前读一模一样的字符串。子字符串 指的是一个字符串中一段连续字符。
提示：
2 <= s.length <= 10^5
s 只包含小写英文字母。

Manacher 算法 + 扫描线
leetcode 题解 https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-substrings/solution/liang-ge-hui-wen-zi-zi-fu-chuan-chang-du-soyb/
第 5 题 https://leetcode.cn/problems/longest-palindromic-substring/
Manacher https://oi-wiki.org/string/manacher/
洛谷 P4555 [国家集训队]最长双回文串 https://www.luogu.com.cn/problem/P4555
 */