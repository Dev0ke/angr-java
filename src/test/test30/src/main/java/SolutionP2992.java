import java.util.Arrays;

public class SolutionP2992 {
    private int n, full;
    private int[][] memo;

    public int selfDivisiblePermutationCount(int n) {
        this.n = n;
        full = (1 << n) - 1;
        memo = new int[n + 1][1 << n];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(1, 0);
    }

    private int dfs(int i, int mask) {
        if (mask == full) return 1;
        if (i > n) return 0;
        if (memo[i][mask] != -1) return memo[i][mask];
        int res = 0;
        for (int j = 0; j < n; j++) {
            if ((mask >> j & 1) == 0 && getGCD(n - j, i) == 1) {
                res += dfs(i + 1, mask | (1 << j));
            }
        }
        return memo[i][mask] = res;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
$2992. 自整除排列的数量
https://leetcode.cn/problems/number-of-self-divisible-permutations/description/

给定一个整数 n，返回 下标从 1 开始 的数组 nums = [1, 2, ..., n]的 可能的排列组合数量，使其满足 自整除 条件。
如果对于每个 1 <= i <= n，满足 gcd(a[i], i) == 1，数组 nums 就是 自整除 的。
数组的 排列 是对数组元素的重新排列组合，例如，下面是数组 [1, 2, 3] 的所有排列组合：
- [1, 2, 3]
- [1, 3, 2]
- [2, 1, 3]
- [2, 3, 1]
- [3, 1, 2]
- [3, 2, 1]
提示：
1 <= n <= 12

状态压缩+记忆化搜索。
https://leetcode.cn/problems/number-of-self-divisible-permutations/solutions/2736127/python-zhuang-tai-ya-suo-ji-yi-hua-sou-s-9mha/
 */