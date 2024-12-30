public class Solution1144 {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(f(nums, 0), f(nums, 1));
    }

    private int f(int[] nums, int pos) {
        int n = nums.length;
        int res = 0;
        for (int i = pos; i < n; i += 2) {
            int max = 0;
            if (i - 1 >= 0) {
                max = Math.max(max, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < n) {
                max = Math.max(max, nums[i] - nums[i + 1] + 1);
            }
            res += max;
        }
        return res;
    }
}
/*
1144. 递减元素使数组呈锯齿状
https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/

给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
如果符合下列情况之一，则数组 A 就是 锯齿数组：
- 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
- 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
返回将数组 nums 转换为锯齿数组所需的最小操作次数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000

贪心 + 分类讨论
从 0 开始或从 1 开始。
时间复杂度 O(n)
空间复杂度 O(1)
 */