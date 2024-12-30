import java.util.BitSet;

public class Solution2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        BitSet set1 = new BitSet(101);
        BitSet set2 = new BitSet(101);
        for (int x : nums1) set1.set(x);
        for (int x : nums2) set2.set(x);
        for (int x : nums1) if (set2.get(x)) ans[0]++;
        for (int x : nums2) if (set1.get(x)) ans[1]++;
        return ans;
    }
}
/*
2956. 找到两个数组中的公共元素
https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/

第 119 场双周赛 T1。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
请你计算以下两个数值：
- 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
- 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
提示：
n == nums1.length
m == nums2.length
1 <= n, m <= 100
1 <= nums1[i], nums2[i] <= 100

集合 模拟。
时间复杂度 O(n+m)
 */