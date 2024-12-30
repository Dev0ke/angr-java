public class Solution2044 {
    private int[] nums;
    private int maxOr, ans;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        maxOr = 0;
        ans = 0;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int orVal) {
        if (i == nums.length) {
            if (maxOr < orVal) {
                maxOr = orVal;
                ans = 1;
            } else if (orVal == maxOr) {
                ans++;
            }
            return;
        }
        // 不选
        dfs(i + 1, orVal);
        // 选
        dfs(i + 1, orVal | nums[i]);
    }
}
/*
2044. 统计按位或能得到最大值的子集数目
https://leetcode.cn/problems/count-number-of-maximum-bitwise-or-subsets/

第 263 场周赛 T3。

给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。

1 <= nums.length <= 16
回溯。如果用二进制枚举的话，时间复杂度会多一个 O(n)。
时间复杂度 O(2^n)
相似题目: 78. 子集
https://leetcode.cn/problems/subsets/
 */