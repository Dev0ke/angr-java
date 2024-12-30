import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2523 {
    private static final int MAX_N = (int) (1e6 + 1);
    private static List<Integer> primes;

    public int[] closestPrimes(int left, int right) {
        if (primes == null) {
            primes = new ArrayList<>();
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
        }

        int[] ans = {-1, -1};
        // n = 1e6, sz = 78498
        int sz = primes.size();
        int min = MAX_N;
        for (int i = 1; i < sz; i++) {
            int pre = primes.get(i - 1);
            int cur = primes.get(i);
            if (pre >= left && cur <= right) {
                if (min > cur - pre) {
                    min = cur - pre;
                    ans = new int[]{pre, cur};
                }
            }
        }
        return ans;
    }
}
/*
2523. 范围内最接近的两个质数
https://leetcode.cn/problems/closest-prime-numbers-in-range/

第 326 场周赛 T4。

给你两个正整数 left 和 right ，请你找到两个整数 num1 和 num2 ，它们满足：
- left <= nums1 < nums2 <= right  。
- nums1 和 nums2 都是 质数 。
- nums2 - nums1 是满足上述条件的质数对中的 最小值 。
请你返回正整数数组 ans = [nums1, nums2] 。如果有多个整数对满足上述条件，请你返回 nums1 最小的质数对。如果不存在符合题意的质数对，请你返回 [-1, -1] 。
如果一个整数大于 1 ，且只能被 1 和它自己整除，那么它是一个质数。
提示：
1 <= left <= right <= 10^6

素数筛 + 枚举
时间复杂度 O(n)
 */