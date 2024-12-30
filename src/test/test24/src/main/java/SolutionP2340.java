public class SolutionP2340 {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int minI = 0, maxI = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minI]) minI = i;
            if (nums[i] >= nums[maxI]) maxI = i;
        }
        int ans = minI + (n - 1 - maxI);
        if (minI > maxI) ans--;
        return ans;
    }
}
/*
$2340. 生成有效数组的最少交换次数
https://leetcode.cn/problems/minimum-adjacent-swaps-to-make-a-valid-array/description/

给定一个 下标从 0 开始 的整数数组 nums。
nums 上的 相邻 元素可以进行 交换。
一个 有效 的数组必须满足以下条件:
- 最大的元素 (如果有多个，则为最大元素中的任何一个) 位于数组中最右边的位置。
- 最小的元素 (如果有多个，则为最小的任何一个元素) 位于数组的最左侧。
返回使 nums 成为有效数组所需的最少交换次数。
提示:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

遍历找最小、最大值。
时间复杂度 O(n)。
 */