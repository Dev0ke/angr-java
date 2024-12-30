import java.util.HashMap;
import java.util.Map;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (!cntMap.containsKey(nums[i]) || cntMap.get(nums[i]) < 2) {
                nums[idx++] = nums[i];
                cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        return idx;
    }
}
/*
80. 删除有序数组中的重复项 II
https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
说明：
为什么返回数值是整数，但输出的答案是数组呢？
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);
// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
提示：
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
nums 已按升序排列

借助 HashMap 统计频次。
 */