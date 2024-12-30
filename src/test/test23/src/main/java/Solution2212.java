public class Solution2212 {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        // 常数 12
        int n = aliceArrows.length;

        int maxScore = 0;
        int[] res = new int[n];
        for (int mask = 0; mask < (1 << n); mask++) {
            // bob 当前状态的分数，箭数，射箭情况
            int score = 0;
            int need = 0;
            int[] bobArrows = new int[n];

            // 从分值高的开始
            for (int k = n - 1; k >= 1; k--) {
                if (((mask >> k) & 1) == 1) {
                    bobArrows[k] = aliceArrows[k] + 1;
                    need += bobArrows[k];
                    if (need > numArrows) {
                        // 状态不成立
                        score = -1;
                        break;
                    }
                    score += k;
                }
            }
            if (maxScore < score) {
                // 多余的箭全部射到 0 区域
                bobArrows[0] = numArrows - need;
                maxScore = score;
                res = bobArrows;
            }
        }
        return res;
    }
}
/*
2212. 射箭比赛中的最大得分
https://leetcode.cn/problems/maximum-points-in-an-archery-competition/

第 285 场周赛 T3。

Alice 和 Bob 是一场射箭比赛中的对手。比赛规则如下：
1.Alice 先射 numArrows 支箭，然后 Bob 也射 numArrows 支箭。
2.分数按下述规则计算：
 1.箭靶有若干整数计分区域，范围从 0 到 11 （含 0 和 11）。
 2.箭靶上每个区域都对应一个得分 k（范围是 0 到 11），Alice 和 Bob 分别在得分 k 区域射中 ak 和 bk 支箭。
 如果 ak >= bk ，那么 Alice 得 k 分。如果 ak < bk ，则 Bob 得 k 分
 3.如果 ak == bk == 0 ，那么无人得到 k 分。
- 例如，Alice 和 Bob 都向计分为 11 的区域射 2 支箭，那么 Alice 得 11 分。如果 Alice 向计分为 11 的区域射 0 支箭，但 Bob 向同一个区域射 2 支箭，那么 Bob 得 11 分。
给你整数 numArrows 和一个长度为 12 的整数数组 aliceArrows ，该数组表示 Alice 射中 0 到 11 每个计分区域的箭数量。现在，Bob 想要尽可能 最大化 他所能获得的总分。
返回数组 bobArrows ，该数组表示 Bob 射中 0 到 11 每个 计分区域的箭数量。且 bobArrows 的总和应当等于 numArrows 。
如果存在多种方法都可以使 Bob 获得最大总分，返回其中 任意一种 即可。
提示：
1 <= numArrows <= 10^5
aliceArrows.length == bobArrows.length == 12
0 <= aliceArrows[i], bobArrows[i] <= numArrows
sum(aliceArrows[i]) == numArrows

状态压缩，bob 得分组合只有 2^12 = 4096 种可能，全部枚举一次即可。
 */