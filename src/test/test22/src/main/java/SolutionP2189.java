public class SolutionP2189 {
    public int houseOfCards(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int res = 0;
        // minn = 堆叠 i 行所需的最少总木棒数
        // 下面用了滚动数组的方式求解
        for (int i = 1; (i * (3 * i + 1)) / 2 <= n; ++i) {
            int[] ndp = new int[n + 1];
            for (int j = 3 * i - 1; j <= n; ++j) {
                if (j - 3 * i >= 0) {
                    ndp[j] += ndp[j - 3 * i];
                }
                ndp[j] += dp[j - (3 * i - 1)];
            }
            dp = ndp;
            res += dp[n];
        }
        return res;
    }
}
/*
$2189. 建造纸牌屋的方法数
https://leetcode.cn/problems/number-of-ways-to-build-house-of-cards/description/

给你一个整数 n，代表你拥有牌的数量。一个 纸牌屋 满足以下条件:
- 一个 纸牌屋 由一行或多行 三角形 和水平纸牌组成。
- 三角形 是由两张纸牌相互靠在一起形成的。
- 一张纸牌必须水平放置在一行中 所有相邻 的三角形之间。
- 比第一行高的任何三角形都必须放在前一行的水平纸牌上。
- 每个三角形都被放置在行中 最左边 的可用位置。
返回使用所有 n 张纸牌可以构建的不同纸牌屋的数量。如果存在一行两个纸牌屋包含不同数量的纸牌，那么两个纸牌屋被认为是不同的。
提示:
1 <= n <= 500

令 dp[i][j]= 堆叠高度为 i，且用 j 根木棒的方案数。
https://leetcode.cn/problems/number-of-ways-to-build-house-of-cards/solutions/1308569/onn-jie-fa-dong-tai-gui-hua-by-newhar-ch1m/
时间复杂度 O(n sqrtn)。
 */