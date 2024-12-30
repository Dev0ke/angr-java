public class Solution3151 {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) return false;
        }
        return true;
    }
}
/*
3151. 特殊数组 I
https://leetcode.cn/problems/special-array-i/description/

第 398 场周赛 T1。

如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

模拟。
时间复杂度 O(n)
 */