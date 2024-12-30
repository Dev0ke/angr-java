public class Solution3216 {
    public String getSmallestString(String s) {
        int n = s.length();
        for (int i = 0; i + 2 <= n; i++) {
            if (s.charAt(i) % 2 != s.charAt(i + 1) % 2) continue;
            String sub = s.substring(i, i + 2);
            String rev = new StringBuilder(sub).reverse().toString();
            if (sub.compareTo(rev) > 0) {
                return s.substring(0, i) + rev + s.substring(i + 2);
            }
        }
        return s;
    }
}
/*
3216. 交换后字典序最小的字符串
https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/description/

第 406 场周赛 T1。

给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
提示：
2 <= s.length <= 100
s 仅由数字组成。

贪心。越靠左越好。
时间复杂度 O(n)。
相似题目: 670. 最大交换
https://leetcode.cn/problems/maximum-swap/
 */