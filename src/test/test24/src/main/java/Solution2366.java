public class Solution2366 {
    public long minimumReplacement(int[] nums) {
        int len = nums.length;
        long ans = 0L;
        int max = nums[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] <= max) {
                max = nums[i];
                continue;
            }
            // 拆成 k 个数，需要 k-1 次拆分
            int k = (nums[i] + max - 1) / max;
            ans += k - 1;
            max = nums[i] / k;
        }
        return ans;
    }
}
/*
2366. 将数组排序的最少替换次数
https://leetcode.cn/problems/minimum-replacements-to-sort-the-array/

第 84 场双周赛 T4。

给你一个下表从 0 开始的整数数组 nums 。每次操作中，你可以将数组中任何一个元素替换为 任意两个 和为该元素的数字。
- 比方说，nums = [5,6,7] 。一次操作中，我们可以将 nums[1] 替换成 2 和 4 ，将 nums 转变成 [5,2,4,7] 。
请你执行上述操作，将数组变成元素按 非递减 顺序排列的数组，并返回所需的最少操作次数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

贪心。后面的数越大，留给前面的数的空间才越多。因此最后一个数必定不会拆。其他数如果要拆分的话，拆分成 k 个最接近的数。
时间复杂度：O(n)
 */