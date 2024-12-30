public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0;
        int last2 = -1;
        int last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}
/*
795. 区间子数组个数
https://leetcode.cn/problems/number-of-subarrays-with-bounded-maximum/

给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组，并返回满足条件的子数组的个数。
生成的测试用例保证结果符合 32-bit 整数范围。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= left <= right <= 10^9

一次遍历。
我们可以将数组中的元素分为三类，并分别用 0, 1, 2 来表示：
- 小于 left，用 0 表示；
- 大于等于 left 且小于等于 right，用 1 表示；
- 大于 right，用 2 表示。
转换为求解不包含 2，且至少包含一个 1 的子数组数目。
last1 表示上一次 1 出现的位置，如果不存在则为 -1；
last2 表示上一次 2 出现的位置，如果不存在则为 -1；
时间复杂度 O(n)
相似题目: 2444. 统计定界子数组的数目
https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/
 */