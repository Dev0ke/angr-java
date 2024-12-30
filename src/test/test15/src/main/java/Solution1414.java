import java.util.TreeSet;

public class Solution1414 {
    public int findMinFibonacciNumbers(int k) {
        TreeSet<Integer> fibTreeSet = new TreeSet<>();
        int f1 = 1;
        int f2 = 1;
        while (f1 + f2 <= k) {
            int f3 = f1 + f2;
            fibTreeSet.add(f3);
            f1 = f2;
            f2 = f3;
        }

        int cnt = 0;
        while (k > 0) {
            Integer floor = fibTreeSet.floor(k);
            k -= java.util.Optional.ofNullable(floor).orElse(1);
            cnt++;
        }
        return cnt;
    }
}
/*
1414. 和为 K 的最少斐波那契数字数目
https://leetcode.cn/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
斐波那契数字定义为：
- F1 = 1
- F2 = 1
- Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
数据保证对于给定的 k ，一定能找到可行解。
提示：
1 <= k <= 10^9

贪心，二分加速。在最大值不超过 k 的斐波那契数中，每次找出最接近 k 的值，减去它，直至为 0.
难点在于证明。
 */