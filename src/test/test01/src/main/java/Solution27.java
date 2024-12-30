import java.util.Arrays;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (val != nums[right]) {
                // left 先赋值再加，因为 left 本身有可能是需要移除的元素。
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        nums = Arrays.copyOfRange(nums, 0, left);
        return nums.length;
    }
}
/*
27. 移除元素
https://leetcode.cn/problems/remove-element/

给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
```
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
```
提示：
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

双指针。
相似题目: 26. 删除有序数组中的重复项
https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */