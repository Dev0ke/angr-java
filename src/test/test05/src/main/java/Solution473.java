import java.util.Arrays;

public class Solution473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int edgeLen = totalLen / 4;
        int n = matchsticks.length;

        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            for (int k = 0; k < n; k++) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {

                    // 去掉 state 的第 k 根火柴得到状态 s1
                    int s1 = state & ~(1 << k);
                    if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= edgeLen) {
                        dp[state] = (dp[s1] + matchsticks[k]) % edgeLen;
                        break;
                    }
                }
            }
        }

        return dp[(1 << n) - 1] == 0;
    }
}
/*
473. 火柴拼正方形
https://leetcode.cn/problems/matchsticks-to-square/

你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。
你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
如果你能使这个正方形，则返回 true ，否则返回 false 。
提示:
1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 10^8

状态压缩动态规划
时间复杂度 O(n*2^n)
相似题目: 698. 划分为k个相等的子集
https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/
 */