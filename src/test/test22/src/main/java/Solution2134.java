import java.util.Arrays;

public class Solution2134 {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < 2 * n; i++) {
            sum -= nums[(i - k) % n];
            sum += nums[i % n];
            maxSum = Math.max(maxSum, sum);
        }
        return k - maxSum;
    }
}
/*
2134. 最少交换次数来组合所有的 1 II
https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together-ii/

第 275 场周赛 T2。

交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。
提示：
1 <= nums.length <= 10^5
nums[i] 为 0 或者 1

定长滑动窗口。环形数组多一个下标取模。
时间复杂度 O(n)
相似题目: $1151. 最少交换次数来组合所有的 1
https://leetcode.cn/problems/minimum-swaps-to-group-all-1s-together/
 */