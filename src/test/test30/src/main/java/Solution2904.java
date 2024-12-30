public class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int l = 0, r = 0;
        String ans = s;
        int sum = 0;
        boolean flag = false;
        while (r < n) {
            sum += cs[r] - '0';
            while (sum >= k) {
                if (sum == k) {
                    flag = true;
                    String sub = s.substring(l, r + 1);
                    if (ans.length() > sub.length()) {
                        ans = sub;
                    } else if (sub.length() == ans.length() && sub.compareTo(ans) < 0) {
                        ans = sub;
                    }
                }

                sum -= cs[l] - '0';
                l++;
            }

            r++;
        }
        return flag ? ans : "";
    }
}
/*
2904. 最短且字典序最小的美丽子字符串
https://leetcode.cn/problems/shortest-and-lexicographically-smallest-beautiful-string/description/

第 367 场周赛 T2。

给你一个二进制字符串 s 和一个正整数 k 。
如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。
令 len 等于 最短 美丽子字符串的长度。
返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。
对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。
- 例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。
提示：
1 <= s.length <= 100
1 <= k <= s.length

滑动窗口 + 字符串比较。
滑动窗口求最短子串类问题
时间复杂度 O(n^2)
 */