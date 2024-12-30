import java.util.Arrays;

public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        long[] f = new long[n + 1];
        int[] pointers = new int[m];
        long[] nums = new long[m];
        Arrays.fill(nums, 1);
        for (int i = 1; i <= n; i++) {
            long minNum = Arrays.stream(nums).min().orElseThrow();
            f[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (nums[j] == minNum) {
                    pointers[j]++;
                    nums[j] = f[pointers[j]] * primes[j];
                }
            }
        }
        return (int) f[n];
    }
}
/*
313. 超级丑数
https://leetcode.cn/problems/super-ugly-number/description/

超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
提示：
1 <= n <= 10^5
1 <= primes.length <= 100
2 <= primes[i] <= 1000
题目数据 保证 primes[i] 是一个质数
primes 中的所有值都 互不相同 ，且按 递增顺序 排列

注意爆 int
相似题目: 264. 丑数 II
https://leetcode.cn/problems/ugly-number-ii/
 */