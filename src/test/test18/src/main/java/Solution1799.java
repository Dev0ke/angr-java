public class Solution1799 {
    public int maxScore(int[] nums) {
        int m = nums.length;

        // 预处理所有可能的最大公约数（只处理 i 小于 j 的情况）
        int[][] gcd = new int[m][m];
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                gcd[i][j] = getGCD(nums[i], nums[j]);
            }
        }

        // dp[mask] 表示操作至状态 mask 时的最大分数
        int[] dp = new int[1 << m];
        // 从小到大枚举状态，注意只有 1 的位数是偶数的状态是有效的
        for (int k = 0; k < 1 << m; k++) {
            int bits = Integer.bitCount(k);
            // 如果 1 的位数不是偶数就跳过，当前的操作次数等于 bits / 2
            if (bits % 2 != 0) {
                continue;
            }
            // 在当前状态的基础上任意去掉两个位上的 1，则 dp[k] 可以从 dp[k \ (1 << i) \ (1 << j)] 转移而来
            for (int i = 0; i < m - 1; i++) {
                if ((k & (1 << i)) == 0) {
                    continue;
                }
                for (int j = i + 1; j < m; j++) {
                    if ((k & (1 << j)) == 0) {
                        continue;
                    }
                    dp[k] = Math.max(dp[k], dp[k - (1 << i) - (1 << j)] + gcd[i][j] * bits / 2);
                }
            }
        }
        return dp[(1 << m) - 1];
    }

    private int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
1799. N 次操作后的最大分数和
https://leetcode.cn/problems/maximize-score-after-n-operations/

给你 nums ，它是一个大小为 2 * n 的正整数数组。你必须对这个数组执行 n 次操作。
在第 i 次操作时（操作编号从 1 开始），你需要：
- 选择两个元素 x 和 y 。
- 获得分数 i * gcd(x, y) 。
- 将 x 和 y 从 nums 中删除。
请你返回 n 次操作后你能获得的分数和最大为多少。
函数 gcd(x, y) 是 x 和 y 的最大公约数。
提示：
1 <= n <= 7
nums.length == 2 * n
1 <= nums[i] <= 10^6

状压 DP
https://leetcode.cn/problems/maximize-score-after-n-operations/solution/by-wangzhizhi-oill/
 */