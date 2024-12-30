import java.util.Arrays;

public class Solution3011 {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && Integer.bitCount(nums[i]) == Integer.bitCount(nums[i - 1]); i++) {
            }
            Arrays.sort(nums, st, i);
        }

        for (int j = 1; j < n; j++) {
            if (nums[j - 1] > nums[j]) return false;
        }
        return true;
    }
}
/*
3011. 判断一个数组是否可以变为有序
https://leetcode.cn/problems/find-if-array-can-be-sorted/description/

第 122 场双周赛 T2。

给你一个下标从 0 开始且全是 正 整数的数组 nums 。
一次 操作 中，如果两个 相邻 元素在二进制下数位为 1 的数目 相同 ，那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。
如果你可以使数组变有序，请你返回 true ，否则返回 false 。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 2^8

分组循环。排序模拟。再判断整个数组是否有序即可。
时间复杂度 O(nlogn)。
 */