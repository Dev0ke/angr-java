import java.util.Arrays;

public class Solution3194 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int mn = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            mn = Math.min(mn, nums[i] + nums[j]);
        }
        return mn / 2.0;
    }
}
/*
3194. 最小元素和最大元素的最小平均值
https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/

第 403 场周赛 T1。

你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
你需要重复以下步骤 n / 2 次：
- 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
- 将 (minElement + maxElement) / 2 加入到 averages 中。
返回 averages 中的 最小 元素。
提示：
2 <= n == nums.length <= 50
n 为偶数。
1 <= nums[i] <= 50

排序 + 双指针。
时间复杂度 O(nlogn)。
 */