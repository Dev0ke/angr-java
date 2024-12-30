import java.util.ArrayList;
import java.util.List;

public class Solution1492 {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }
        factors.sort(null);
        return factors.size() < k ? -1 : factors.get(k - 1);
    }
}
/*
1492. n 的第 k 个因子
https://leetcode.cn/problems/the-kth-factor-of-n/description/

给你两个正整数 n 和 k 。
如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。
考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
提示：
1 <= k <= n <= 1000
进阶：
你可以设计时间复杂度小于 O(n) 的算法来解决此问题吗？

枚举 + 排序。
时间复杂度 O(mlogm)。其中 m = sqrt(n)。
 */