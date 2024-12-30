public class Solution1884 {
    public int twoEggDrop(int n) {
        return superEggDrop(2, n);
    }

    private int superEggDrop(int k, int n) {
        if (n == 1) {
            return 1;
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = 1 + dp[i - 1][j - 1] + dp[i - 1][j];
            }
            if (dp[i][k] >= n) {
                return i;
            }
        }
        return -1;
    }
}
/*
1884. 鸡蛋掉落-两枚鸡蛋
https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/

给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
提示：
1 <= n <= 1000

动态规划
时间复杂度 O(n)
空间复杂度 O(n)
相似题目: 887. 鸡蛋掉落
https://leetcode.cn/problems/super-egg-drop/
 */