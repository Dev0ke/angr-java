import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2761 {
    public List<List<Integer>> findPrimePairs(int n) {
        // 线性筛
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
        Set<Integer> set = new HashSet<>(primes);

        List<List<Integer>> resList = new ArrayList<>();
        for (Integer x : primes) {
            if (x > n / 2) break;
            int y = n - x;
            if (set.contains(y)) {
                resList.add(List.of(x, y));
            }
        }
        return resList;
    }
}
/*
2761. 和等于目标值的质数对
https://leetcode.cn/problems/prime-pairs-with-target-sum/

第 352 场周赛 T2。

给你一个整数 n 。如果两个整数 x 和 y 满足下述条件，则认为二者形成一个质数对：
- 1 <= x <= y <= n
- x + y == n
- x 和 y 都是质数
请你以二维有序列表的形式返回符合题目要求的所有 [xi, yi] ，列表需要按 xi 的 非递减顺序 排序。如果不存在符合要求的质数对，则返回一个空数组。
注意：质数是大于 1 的自然数，并且只有两个因子，即它本身和 1 。
提示：
1 <= n <= 10^6
 */