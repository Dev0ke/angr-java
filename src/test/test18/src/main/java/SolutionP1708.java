import java.util.Arrays;

public class SolutionP1708 {
    public int[] largestSubarray(int[] nums, int k) {
        int len = nums.length;
        int max = 0;
        int maxI = 0;
        for (int i = 0; i + k <= len; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxI = i;
            }
        }
        return Arrays.copyOfRange(nums, maxI, maxI + k);
    }
}
/*
$1708. 长度为 K 的最大子数组
https://leetcode.cn/problems/largest-subarray-length-k/

在数组 A 和数组 B 中，对于第一个满足 A[i] != B[i] 的索引 i ，当 A[i] > B[i] 时，数组 A 大于数组 B。
例如，对于索引从 0 开始的数组：
- [1,3,2,4] > [1,2,2,4] ，因为在索引 1 上， 3 > 2。
- [1,4,4,4] < [2,1,1,1] ，因为在索引 0 上， 1 < 2。
一个数组的子数组是原数组上的一个连续子序列。
给定一个包含不同整数的整数类型数组 nums ，返回 nums 中长度为 k 的最大子数组。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 中的所有整数都是不同的。
进阶：如果允许 nums 中存在相同元素，你该如何解决该问题？

由于整数都是不同的，因此在 [0, n-1-k] 找到最大的整数即可。
时间复杂度 O(n)
进阶问题的话，时间复杂度应该是 O(n^2)
 */