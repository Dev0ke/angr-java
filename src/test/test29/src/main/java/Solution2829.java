import java.util.HashSet;
import java.util.Set;

public class Solution2829 {
    // O(n)
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int i = 1;
        while (set.size() < n) {
            if (!set.contains(k - i)) {
                set.add(i);
            }
            i++;
        }

        int ans = 0;
        for (Integer x : set) {
            ans += x;
        }
        return ans;
    }

    // O(1)
    public int minimumSum2(int n, int k) {
        int m = Math.min(k / 2, n);
        return (m * (m + 1) + (k * 2 + n - m - 1) * (n - m)) / 2;
    }
}
/*
2829. k-avoiding 数组的最小总和
https://leetcode.cn/problems/determine-the-minimum-sum-of-a-k-avoiding-array/

第 359 场周赛 T2。

给你两个整数 n 和 k 。
对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
返回长度为 n 的 k-avoiding 数组的可能的最小总和。
提示：
1 <= n, k <= 50

贪心 + 两数之和。也有数学解法。
时间复杂度 O(n)
 */