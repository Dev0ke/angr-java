public class Solution2091 {
    public int minimumDeletions(int[] nums) {
        int minIdx = 0;
        int maxIdx = 0;
        int len = nums.length;
        // 找出 最小值 和 最大值 的下标
        for (int i = 0; i < len; i++) {
            // 数组由若干 互不相同 的整数组成。
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
        }
        int minDistanceLeft = minIdx + 1;
        int minDistanceRight = len - minIdx;
        int maxDistanceLeft = maxIdx + 1;
        int maxDistanceRight = len - maxIdx;
        // 两边删除
        int res1 = Math.min(minDistanceLeft, minDistanceRight) + Math.min(maxDistanceLeft, maxDistanceRight);
        // 左侧删除
        int res2 = Math.max(minDistanceLeft, maxDistanceLeft);
        // 右侧删除
        int res3 = Math.max(minDistanceRight, maxDistanceRight);
        return Math.min(res1, Math.min(res2, res3));
    }
}
/*
2091. 从数组中移除最大值和最小值
https://leetcode.cn/problems/removing-minimum-and-maximum-from-array/

第 269 场周赛 T3。

给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
返回将数组中最小值和最大值 都 移除需要的最小删除次数。

考虑三种情况，取最小值即可。
 */