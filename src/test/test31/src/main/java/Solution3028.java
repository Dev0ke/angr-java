public class Solution3028 {
    public int returnToBoundaryCount(int[] nums) {
        int s = 0;
        int ans = 0;
        for (int v : nums) {
            s += v;
            if (s == 0) ans++;
        }
        return ans;
    }
}
/*
3028. 边界上的蚂蚁
https://leetcode.cn/problems/ant-on-the-boundary/description/

第 383 场周赛 T1。

边界上有一只蚂蚁，它有时向 左 走，有时向 右 走。
给你一个 非零 整数数组 nums 。蚂蚁会按顺序读取 nums 中的元素，从第一个元素开始直到结束。每一步，蚂蚁会根据当前元素的值移动：
- 如果 nums[i] < 0 ，向 左 移动 -nums[i]单位。
- 如果 nums[i] > 0 ，向 右 移动 nums[i]单位。
返回蚂蚁 返回 到边界上的次数。
注意：
- 边界两侧有无限的空间。
- 只有在蚂蚁移动了 |nums[i]| 单位后才检查它是否位于边界上。换句话说，如果蚂蚁只是在移动过程中穿过了边界，则不会计算在内。
提示：
1 <= nums.length <= 100
-10 <= nums[i] <= 10
nums[i] != 0

模拟。
时间复杂度 O(n)
 */