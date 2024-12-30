import java.util.Arrays;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        Arrays.fill(nums, left, right, 0);
    }
}
/*
283. 移动零
https://leetcode.cn/problems/move-zeroes/

给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
请注意 ，必须在不复制数组的情况下原地对数组进行操作。
提示:
1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1

双指针。相当于 27 题需要移除的元素为 0，然后剩余的数组部分再补充上 0。
相似题目: 27. 移除元素
https://leetcode.cn/problems/remove-element/
 */