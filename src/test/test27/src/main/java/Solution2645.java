public class Solution2645 {
    // 枚举
    public int addMinimum(String word) {
        int n = word.length();
        int t = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i - 1) >= word.charAt(i)) {
                t++;
            }
        }
        return t * 3 - n;
    }

    // 公式法
    public int addMinimum2(String word) {
        int n = word.length();
        // s[0] - 'a'
        // 'c' - s[n-1]
        // 等价于 s[0] - s[n-1] + 2
        int ans = word.charAt(0) - word.charAt(n - 1) + 2;
        for (int i = 1; i < n; i++) {
            ans += (word.charAt(i) - word.charAt(i - 1) + 2) % 3;
        }
        return ans;
    }
}
/*
2645. 构造有效字符串的最少插入数
https://leetcode.cn/problems/minimum-additions-to-make-valid-string/

第 341 场周赛 T3。

给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
提示：
1 <= word.length <= 50
word 仅由字母 "a"、"b" 和 "c" 组成。

数据范围非常小。比赛时求快使用了 二分查找 + LCS。
实际上可以做到 O(n) 时间复杂度
 */