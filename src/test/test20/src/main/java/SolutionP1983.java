import java.util.HashMap;
import java.util.Map;

public class SolutionP1983 {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum = 0, ans = 0;
        Map<Integer, Integer> sumFirstMap = new HashMap<>();
        sumFirstMap.put(0, -1);
        for (int j = 0; j < n; j++) {
            sum += nums1[j] - nums2[j];
            if (sumFirstMap.containsKey(sum)) {
                int i = sumFirstMap.get(sum);
                ans = Math.max(ans, j - i);
            } else {
                sumFirstMap.put(sum, j);
            }
        }
        return ans;
    }
}
/*
$1983. 范围和相等的最宽索引对
https://leetcode.cn/problems/widest-pair-of-indices-with-equal-range-sum/description/

给定两个 以0为索引 的二进制数组 nums1 和 nums2 。找出 最宽 的索引对 (i, j) ，使的 i <= j 并且 nums1[i] + nums1[i+1] + ... + nums1[j] == nums2[i] + nums2[i+1] + ... + nums2[j]。
最宽 的指标对是指在 i 和 j 之间的 距离最大 的指标对。一对指标之间的 距离 定义为 j - i + 1 。
返回 最宽 索引对的 距离 。如果没有满足条件的索引对，则返回 0 。
提示:
n == nums1.length == nums2.length
1 <= n <= 10^5
nums1[i] 仅为 0 或 1.
nums2[i] 仅为 0 或 1.

前缀和 + 哈希表。
时间复杂度 O(n)。
 */