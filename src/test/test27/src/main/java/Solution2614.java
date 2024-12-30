import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2614 {
    private static final int MAX_N = (int) 4e6 + 1;
    private static Set<Integer> primeSet;

    public int diagonalPrime(int[][] nums) {
        if (primeSet == null) {
            List<Integer> primes = new ArrayList<>();
            boolean[] isPrime = new boolean[MAX_N];
            Arrays.fill(isPrime, true);
            for (int i = 2; i < MAX_N; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) < MAX_N; j++) {
                    isPrime[i * primes.get(j)] = false;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            primeSet = new HashSet<>(primes);
        }

        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (primeSet.contains(nums[i][i])) {
                max = Math.max(max, nums[i][i]);
            }
            if (primeSet.contains(nums[i][n - 1 - i])) {
                max = Math.max(max, nums[i][n - 1 - i]);
            }
        }
        return max;
    }
}
/*
2614. 对角线上的质数
https://leetcode.cn/problems/prime-in-diagonal/

第 340 场周赛 T1。

给你一个下标从 0 开始的二维整数数组 nums 。
返回位于 nums 至少一条 对角线 上的最大 质数 。如果任一对角线上均不存在质数，返回 0 。
注意：
- 如果某个整数大于 1 ，且不存在除 1 和自身之外的正整数因子，则认为该整数是一个质数。
- 如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，则认为整数 val 位于 nums 的一条对角线上。
在上图中，一条对角线是 [1,5,9] ，而另一条对角线是 [3,5,7] 。
提示：
1 <= nums.length <= 300
nums.length == numsi.length
1 <= nums[i][j] <= 4*10^6

线性筛 + 模拟。
线性筛预处理 4e6 内所有质数。再在 O(1) 时间内快速判断某个数是否为质数，若是质数，统计最大值。
时间复杂度 O(4e6 + n)
 */