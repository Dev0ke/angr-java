import java.util.Arrays;

public class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
/*
1984. 学生分数的最小差值
https://leetcode.cn/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

第 256 场周赛 T1。

给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
返回可能的 最小差值 。
提示：
1 <= k <= nums.length <= 1000
0 <= nums[i] <= 10^5

排序后 固定大小的滑动窗口比较差值
时间复杂度 O(nlogn)
 */