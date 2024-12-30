import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2472 {
    public int maxPalindromes(String s, int k) {
        int len = s.length();
        if (k == 1) {
            return len;
        }

        // dp[i][j] 表示 s[i..j] 是否为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        List<int[]> rangeList = new ArrayList<>();
        char[] chars = s.toCharArray();
        // 注意此处 left <= len
        for (int left = 1; left <= len; left++) {
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

                // 每个子字符串的长度 至少 为 k
                if (dp[i][j] && j - i + 1 >= k) {
                    rangeList.add(new int[]{i, j});
                }
            }
        }

        // solution1751
        int sz = rangeList.size();
        rangeList.sort(Comparator.comparingInt(o -> o[1]));
        int[] f = new int[sz + 1];
        for (int i = 1; i <= sz; i++) {
            int[] ei = rangeList.get(i - 1);

//            int last = 0;
//            for (int j = i - 1; j - 1 >= 0; j--) {
//                int[] ej = rangeList.get(j - 1);
//
//                if (ej[1] < ei[0]) {
//                    last = j;
//                    break;
//                }
//            }
            // 二分优化
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (rangeList.get(mid)[1] >= ei[0]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int last = left;

            // 选 or 不选
            f[i] = Math.max(f[i - 1], f[last] + 1);
        }
        return f[sz];
    }
}
/*
2472. 不重叠回文子字符串的最大数目
https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings/

第 319 场周赛 T4。

给你一个字符串 s 和一个 正 整数 k 。
从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串：
- 每个子字符串的长度 至少 为 k 。
- 每个子字符串是一个 回文串 。
返回最优方案中能选择的子字符串的 最大 数目。
子字符串 是字符串中一个连续的字符序列。
提示：
1 <= k <= s.length <= 2000
s 仅由小写英文字母组成

相似题目: 1235. 规划兼职工作
https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
1751. 最多可以参加的会议数目 II
https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/
 */