public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int d = 0;
        int cntX = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                d++;
                if (s1.charAt(i) == 'x') {
                    cntX++;
                }
            }
        }
        // 奇数个字符不同，无解
        if (d % 2 == 1) {
            return -1;
        }
        // 数论向上取整法
        return (cntX + 1) / 2 + (d - cntX + 1) / 2;
    }
}
/*
1247. 交换字符使得字符串相同
https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/

第 161 场周赛 T1。

有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
提示：
1 <= s1.length, s2.length <= 1000
s1, s2 只包含 'x' 或 'y'。

贪心。
第一步，剔除所有下标相等时相同的字符。
第二歩，余下字符串，优先组合成 [xx,yy] 或 [yy,xx] 交换次数为 1
第三步，余下字符串，考虑组合成 [xy,yx] 或 [yx,yx] 交换次数为 2
 */