import java.util.HashSet;
import java.util.Set;

public class Solution3002 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int v : nums1) set1.add(v);
        for (int v : nums2) set2.add(v);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // 交集
        set1.removeAll(intersection); // 补集 1
        set2.removeAll(intersection); // 补集 2
        int except1 = Math.min(n / 2, set1.size());
        int except2 = Math.min(n / 2, set2.size());
        int ans = except1 + except2;
        ans += Math.min(intersection.size(), n - except1 - except2);
        return ans;
    }
}
/*
3002. 移除后集合的最多元素数
https://leetcode.cn/problems/maximum-size-of-a-set-after-removals/description/

第 379 场周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。
你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元素插入到集合 s 中。
返回集合 s可能的 最多 包含多少元素。
提示：
n == nums1.length == nums2.length
1 <= n <= 2 * 10^4
n是偶数。
1 <= nums1[i], nums2[i] <= 10^9

容斥原理。贪心。
从两个补集里面分别最多选 n/2 个，再从交集里面最多选剩下的
时间复杂度 O(n + m)
 */