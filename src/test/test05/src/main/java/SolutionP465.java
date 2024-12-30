public class SolutionP465 {
    public int minTransfers(int[][] distributions) {
        int n = 12;

        int[] cnt = new int[n];
        for (int[] distribution : distributions) {
            cnt[distribution[0]] -= distribution[2];
            cnt[distribution[1]] += distribution[2];
        }

        int[] dp = new int[1 << n];
        for (int state = 1; state < (1 << n); state++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) == 1) {
                    sum += cnt[k];
                }

                if (sum > 0) {
                    dp[state] = Integer.MAX_VALUE / 2;
                } else {
                    dp[state] = Integer.bitCount(state) - 1;
                    for (int subState = state; subState > 0; subState = (subState - 1) & state) {
                        dp[state] = Math.min(dp[state], dp[state ^ subState] + dp[subState]);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
/*
$465. 最优账单平衡
https://leetcode.cn/problems/optimal-account-balancing/

一群朋友在度假期间会相互借钱。比如说，小爱同学支付了小新同学的午餐共计 10 美元。如果小明同学支付了小爱同学的出租车钱共计 5 美元。
我们可以用一个三元组 (x, y, z) 表示一次交易，表示 x 借给 y 共计 z 美元。
用 0, 1, 2 表示小爱同学、小新同学和小明同学（0, 1, 2 为人的标号），上述交易可以表示为 [[0, 1, 10], [2, 0, 5]]。
给定一群人之间的交易信息列表，计算能够还清所有债务的最小次数。
注意：
一次交易会以三元组 (x, y, z) 表示，并有 x ≠ y 且 z > 0。
人的标号可能不是按顺序的，例如标号可能为 0, 1, 2 也可能为 0, 2, 6。
Constraints:
1 <= transactions.length <= 8
transactions[i].length == 3
0 <= fromi, toi < 12
fromi != toi
1 <= amounti <= 100

状态压缩动态规划
时间复杂度 O(3^n)
空间复杂度 O(2^n)
 */