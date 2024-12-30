public class Solution1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // 只看第一张牌即可
        int a = tops[0];
        int b = bottoms[0];
        int cntA = cnt(tops, bottoms, a);
        if (cntA != -1) {
            return cntA;
        }
        return cnt(tops, bottoms, b);
    }

    // 将 tops 全部翻为 x 或者 将 bottoms 全部翻为 x 的较小次数
    private int cnt(int[] tops, int[] bottoms, int x) {
        int len = tops.length;
        int cntTop = 0;
        int cntBottom = 0;
        for (int i = 0; i < len; i++) {
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            } else if (tops[i] != x) {
                cntTop++;
            } else if (bottoms[i] != x) {
                cntBottom++;
            }
        }
        return Math.min(cntTop, cntBottom);
    }
}
/*
1007. 行相等的最少多米诺旋转
https://leetcode.cn/problems/minimum-domino-rotations-for-equal-row/

在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
如果无法做到，返回 -1.
提示：
2 <= tops.length <= 2 * 10^4
bottoms.length == tops.length
1 <= tops[i], bottoms[i] <= 6

只看第一张牌即可，假设 A = tops[0], B = bottoms[0]；
看是否能将 tops 全部翻为 A 或者将 bottoms 全部翻为 A，如果可行，返回其较小次数；
看是否能将 tops 全部翻为 B 或者将 bottoms 全部翻为 B，如果可行，返回其较小次数；否则返回 -1；
 */