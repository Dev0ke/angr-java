public class Solution189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int mod = k % len;
        reverseArrays(nums, 0, len - 1);
        reverseArrays(nums, 0, mod - 1);
        reverseArrays(nums, mod, len - 1);
    }

    private void reverseArrays(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
/*
189. 旋转数组
https://leetcode.cn/problems/rotate-array/

给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
提示：
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5
进阶：
尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？

3 次数组翻转即可。
原始数组          1,2,3,4,5,6,7
翻转所有元素      7,6,5,4,3,2,1
翻转 [0,mod-1]   5,6,7,4,3,2,1
翻转 [mod,n-1]   5,6,7,1,2,3,4
时间复杂度 O(n)
空间复杂度 O(1)
 */