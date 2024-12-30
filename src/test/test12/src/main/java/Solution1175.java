import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1175 {
    public int numPrimeArrangements(int n) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int rightIdx = binarySearchRightBound(primes, n);
        // 质数个数
        int cntPrime = rightIdx + 1;

        // 全排列 cntPrime! * (n-cntPrime)!
        long mod = 1000000007;
        long ans = 1;
        int a = cntPrime;
        int b = n - cntPrime;
        while (a > 1) {
            ans = ans * a % mod;
            a--;
        }
        while (b > 1) {
            ans = ans * b % mod;
            b--;
        }
        return (int) ans;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }

    private static final long MOD = 1000000007;

    public int numPrimeArrangements2(int n) {
        // 质数个数
        int cntPrime = countPrimes(n + 1);
        // 非质数个数
        int noPrime = n - cntPrime;

        return (int) (factorial(cntPrime) * factorial(noPrime) % MOD);
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
            res %= MOD;
        }
        return res;
    }

    // solution 204 线性筛
    private int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = false;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
/*
1175. 质数排列
https://leetcode.cn/problems/prime-arrangements/

第 152 场周赛 T1。

请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
提示：
1 <= n <= 100

组合数学，设有 a 个质数，b 个合数，则结果为 a! * b!
相似题目: 204. 计数质数
https://leetcode.cn/problems/count-primes/
 */