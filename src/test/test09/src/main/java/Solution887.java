public class Solution887 {
    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }
        // f[t][k] 表示可以有 t 次操作 k 枚鸡蛋（显然 t 最大不会超过 n）
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }

        // 状态转移 f[t][k] = 1 + f[t - 1][k - 1] + f[i - 1][j];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            // 只需找出最小的满足 f[t][k] >= n 的 t
            if (dp[i][k] >= n) {
                return i;
            }
        }
        return -1;
    }
}
/*
887. 鸡蛋掉落
https://leetcode.cn/problems/super-egg-drop/

给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
提示：
1 <= k <= 100
1 <= n <= 10^4

动态规划
时间复杂度 O(kn)
空间复杂度 O(kn)
相似题目: 1884. 鸡蛋掉落-两枚鸡蛋
https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/
 */