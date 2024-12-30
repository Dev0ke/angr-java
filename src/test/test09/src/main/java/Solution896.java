public class Solution896 {
    public boolean isMonotonic(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        return isAsc(nums) || isDesc(nums);
    }

    /**
     * 单调递增
     */
    private boolean isAsc(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 单调递减
     */
    private boolean isDesc(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
/*
896. 单调数列
https://leetcode.cn/problems/monotonic-array/

第 100 场周赛 T1。

如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。
提示：
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

分别判断 单调递增 或 单调递减 即可。|| 自带剪枝
 */