import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2967 {
    static List<Long> pal;

    static {
        // size = 199998, max = 9999999999
        pal = new ArrayList<>();
        for (int L = 1; L <= 5; L++) {
            int low = (int) Math.pow(10, L - 1);
            int high = (int) Math.pow(10, L);
            // Check for odd-length palindromes
            for (int root = low; root < high; root++) {
                long p = root;
                for (int x = root / 10; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                pal.add(p);
            }
            // Check for even-length palindromes
            for (int root = low; root < high; root++) {
                long p = root;
                for (int x = root; x > 0; x /= 10) {
                    p = p * 10 + x % 10;
                }
                pal.add(p);
            }
        }
        pal.sort(null);
    }

    public long minimumCost(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long median = nums[n / 2];
        int i = lowerBound(pal, median);
        long ans = Long.MAX_VALUE;
        for (int j = Math.max(0, i - 1); j <= i + 1; j++) {
            long y = pal.get(j);
            ans = Math.min(ans, getCost(nums, y));
        }
        return ans;
    }

    private long getCost(int[] nums, long y) {
        long cost = 0;
        for (int v : nums) {
            cost += Math.abs(y - v);
        }
        return cost;
    }

    private int lowerBound(List<Long> a, long key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
2967. 使数组成为等数数组的最小代价
https://leetcode.cn/problems/minimum-cost-to-make-array-equalindromic/description/

第 376 场周赛 T3。

给你一个长度为 n 下标从 0 开始的整数数组 nums 。
你可以对 nums 执行特殊操作 任意次 （也可以 0 次）。每一次特殊操作中，你需要 按顺序 执行以下步骤：
- 从范围 [0, n - 1] 里选择一个下标 i 和一个 正 整数 x 。
- 将 |nums[i] - x| 添加到总代价里。
- 将 nums[i] 变为 x 。
如果一个正整数正着读和反着读都相同，那么我们称这个数是 回文数 。比方说，121 ，2552 和 65756 都是回文数，但是 24 ，46 ，235 都不是回文数。
如果一个数组中的所有元素都等于一个整数 y ，且 y 是一个小于 10^9 的 回文数 ，那么我们称这个数组是一个 等数数组 。
请你返回一个整数，表示执行任意次特殊操作后使 nums 成为 等数数组 的 最小 总代价。
提示：
1 <= n <= 10^5
1 <= nums[i] <= 10^9

回文根 + 中位数
先将 1e10 内的回文数预处理出来。要使总代价尽可能小，那越接近中位数越好，二分加速找到对应回文数下标 取最小值。
时间复杂度 O(nlogn)
相似题目: 866. 回文素数
https://leetcode.cn/problems/prime-palindrome/
906. 超级回文数
https://leetcode.cn/problems/super-palindromes/
2217. 找到指定长度的回文数
https://leetcode.cn/problems/find-palindrome-with-fixed-length/
 */