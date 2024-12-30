import java.util.List;

public class Solution2855 {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        int minI = 0;
        for (int i = 0; i < n; i++) {
            if (min > nums.get(i)) {
                min = nums.get(i);
                minI = i;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums.get((minI + i - 1) % n) > nums.get((minI + i) % n)) {
                return -1;
            }
        }

        return (n - minI) % n;
    }
}
/*
2855. 使数组成为递增数组的最少右移次数
https://leetcode.cn/problems/minimum-right-shifts-to-sort-the-array/

第 113 场双周赛 T1。

给你一个长度为 n 下标从 0 开始的数组 nums ，数组中的元素为 互不相同 的正整数。请你返回让 nums 成为递增数组的 最少右移 次数，如果无法得到递增数组，返回 -1 。
一次 右移 指的是同时对所有下标进行操作，将下标为 i 的元素移动到下标 (i + 1) % n 处。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
nums 中的整数互不相同。

第一遍遍历找到最小值下标，第二遍遍历判段是否是递增数组
时间复杂度 O(n)
 */