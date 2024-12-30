import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution204 {
    /**
     * 埃氏筛
     * 时间复杂度 O(nloglogn)
     * 空间复杂度 O(n)
     */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                cnt++;
                if (i * i < n) {
                    for (int j = i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * 线性筛
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int countPrimes2(int n) {
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
204. 计数质数
https://leetcode.cn/problems/count-primes/

统计所有小于非负整数 n 的质数的数量。
提示：
0 <= n <= 5 * 10^6

模板题。统计 [2,n) 的质数数量
 */