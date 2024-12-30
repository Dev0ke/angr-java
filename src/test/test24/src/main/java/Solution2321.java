import java.util.Arrays;

public class Solution2321 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        int[] nums1sub2 = new int[n];
        int[] nums2sub1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1sub2[i] = nums1[i] - nums2[i];
            nums2sub1[i] = nums2[i] - nums1[i];
        }
        return Math.max(sum1 + maxSubArray(nums2sub1), sum2 + maxSubArray(nums1sub2));
    }

    private int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
/*
2321. 拼接数组的最大分数
https://leetcode.cn/problems/maximum-score-of-spliced-array/

第 299 场周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度都是 n 。
你可以选择两个整数 left 和 right ，其中 0 <= left <= right < n ，接着 交换 两个子数组 nums1[left...right] 和 nums2[left...right] 。
- 例如，设 nums1 = [1,2,3,4,5] 和 nums2 = [11,12,13,14,15] ，整数选择 left = 1 和 right = 2，那么 nums1 会变为 [1,12,13,4,5] 而 nums2 会变为 [11,2,3,14,15] 。
你可以选择执行上述操作 一次 或不执行任何操作。
数组的 分数 取 sum(nums1) 和 sum(nums2) 中的最大值，其中 sum(arr) 是数组 arr 中所有元素之和。
返回 可能的最大分数 。
子数组 是数组中连续的一个元素序列。arr[left...right] 表示子数组包含 nums 中下标 left 和 right 之间的元素（含 下标 left 和 right 对应元素）。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
1 <= nums1[i], nums2[i] <= 10^4

最大子数组和
时间复杂度 O(n)
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */