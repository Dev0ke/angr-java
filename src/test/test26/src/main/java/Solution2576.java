import java.util.Arrays;

public class Solution2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 1;
        int right = n / 2 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left - 1) * 2;
    }

    // 是否可以构造 k 对匹配（最小 k 个数和最大 k 个数 一一匹配）
    private boolean checkMid(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[n - k + i]) {
                return false;
            }
        }
        return true;
    }
}
/*
2576. 求出最多标记下标
https://leetcode.cn/problems/find-the-maximum-number-of-marked-indices/

第 334 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。
一开始，所有下标都没有被标记。你可以执行以下操作任意次：
- 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

二分 + 贪心。
二分查找转化为判定问题：判定是否可以构造 k 对匹配。根据贪心：当最小 k 个数和最大 k 个数一一匹配时，配对数最大。
时间复杂度 O(nlogn)
 */