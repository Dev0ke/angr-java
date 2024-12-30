public class Solution2012 {
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 1; i <= len - 2; i++) {
            if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res++;
            }
        }
        // leftMax[i] 表示 nums[0, i] 的最大值
        int[] leftMax = new int[len];
        leftMax[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }
        // rightMin[i] 表示 nums[i, len-1] 的最小值
        int[] rightMin = new int[len];
        rightMin[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = 1; i <= len - 2; i++) {
            if (leftMax[i - 1] < nums[i] && nums[i] < rightMin[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
/*
2012. 数组美丽值求和
https://leetcode.cn/problems/sum-of-beauty-in-the-array/

第 259 场周赛 T2。

给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
- 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
- 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
- 0，如果上述条件全部不满足
返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。

可以看出 美丽值 等于 2 比等于 1 严格。等于 2 的情况是 等于 1 情况的真子集。
可以先统计 1, 然后符合 2 条件的再加上 1。
三次顺序遍历。
时间复杂度 O(n)
 */