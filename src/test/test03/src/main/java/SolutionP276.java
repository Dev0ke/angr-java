public class SolutionP276 {
    public int numWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        // f[i] 为前 i 个栅栏的方案数
        int[] f = new int[n];
        f[0] = k;
        f[1] = k * k;
        for (int i = 2; i < n; i++) {
            f[i] = (f[i - 1] + f[i - 2]) * (k - 1);
        }
        return f[n - 1];
    }
}
/*
$276. 栅栏涂色
https://leetcode.cn/problems/paint-fence/

有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案：
- 每个栅栏柱可以用其中 一种 颜色进行上色。
- 相邻的栅栏柱 最多连续两个 颜色相同。
给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。
提示：
1 <= n <= 50
1 <= k <= 10^5
题目数据保证：对于输入的 n 和 k ，其答案在范围 [0, 2^31 - 1] 内

动态规划
golang 的写法更优雅
func numWays(n int, k int) int {
    f0, f1 := 0, k
    for i := 1; i < n; i++ {
        f0, f1 = f1, (k-1)*(f0+f1)
    }
    return f0 + f1
}
 */