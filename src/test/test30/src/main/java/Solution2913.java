import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2913 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                long d = set.size();
                ans += d * d;
                ans %= MOD;
            }
        }
        return (int) ans;
    }
}
/*
2913. 子数组不同元素数目的平方和 I
https://leetcode.cn/problems/subarrays-distinct-element-sum-of-squares-i/

第 116 场双周赛 T1。

给你一个下标从 0 开始的整数数组 nums 。
定义 nums 一个子数组的 不同计数 值如下：
- 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
请你返回 nums 中所有子数组的 不同计数 的 平方 和。
由于答案可能会很大，请你将它对 10^9 + 7 取余 后返回。
子数组指的是一个数组里面一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

两层 for 循环 + 哈希表
时间复杂度 O(n^2)
 */