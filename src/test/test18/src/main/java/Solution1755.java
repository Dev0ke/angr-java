import java.util.TreeSet;

public class Solution1755 {
    public int minAbsDifference(int[] nums, int goal) {
        // meet in the middle（折半搜索）
        // 时间复杂度 = O(n*2^(n/2)) <= 40 * 1,048,576 (n 最大取到 40)
        int len = nums.length;
        // 拆分成两个长度接近的子数组
        int len1 = len / 2;
        int len2 = len - len1;
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        System.arraycopy(nums, 0, nums1, 0, len1);
        System.arraycopy(nums, len1, nums2, 0, len2);

        // 预处理 nums2 子集和，TreeSet 便于二分
        TreeSet<Integer> treeSet = getNumsSubsetSum(nums2);
        int min = Integer.MAX_VALUE;
        for (int state = 0; state < (1 << len1); state++) {
            // nums1 子集和
            int sum1 = 0;
            for (int k = 0; k < len1; k++) {
                if (((state >> k) & 1) == 1) {
                    sum1 += nums1[k];
                }
            }

            // 期望找到最接近的 nums2 子集和
            int sum2 = goal - sum1;
            Integer floor = treeSet.floor(sum2);
            if (floor != null) {
                min = Math.min(min, Math.abs(sum1 + floor - goal));
            }
            Integer ceiling = treeSet.ceiling(sum2);
            if (ceiling != null) {
                min = Math.min(min, Math.abs(sum1 + ceiling - goal));
            }
        }
        return min;
    }

    private TreeSet<Integer> getNumsSubsetSum(int[] nums) {
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int state = 0; state < (1 << n); state++) {
            int sum = 0;
            for (int k = 0; k < n; k++) {
                if (((state >> k) & 1) > 0) {
                    sum += nums[k];
                }
            }
            treeSet.add(sum);
        }
        return treeSet;
    }
}
/*
1755. 最接近目标值的子序列和
https://leetcode.cn/problems/closest-subsequence-sum/

第 227 场周赛 T4。

给你一个整数数组 nums 和一个目标值 goal 。
你需要从 nums 中选出一个子序列，使子序列元素总和最接近 goal 。也就是说，如果子序列元素和为 sum ，你需要 最小化绝对差 abs(sum - goal) 。
返回 abs(sum - goal) 可能的 最小值 。
注意，数组的子序列是通过移除原始数组中的某些元素（可能全部或无）而形成的数组。
提示：
1 <= nums.length <= 40
-10^7 <= nums[i] <= 10^7
-10^9 <= goal <= 10^9

折半搜索。
相似题目: 2035. 将数组分成两个数组并最小化数组和的差
https://leetcode.cn/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
 */