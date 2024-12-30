import java.util.ArrayList;
import java.util.List;

public class Solution491 {
    private int[] nums;
    private List<Integer> res;
    private List<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        ans = new ArrayList<>();
        dfs(0, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(int i, int pre) {
        if (i == nums.length) {
            if (res.size() >= 2) {
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        // 不选
        if (nums[i] != pre) {
            dfs(i + 1, pre);
        }
        // 选
        if (nums[i] >= pre) {
            res.add(nums[i]);
            dfs(i + 1, nums[i]);
            res.remove(res.size() - 1);
        }
    }
}
/*
491. 非递减子序列
https://leetcode.cn/problems/non-decreasing-subsequences/description/

给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
提示：
1 <= nums.length <= 15
-100 <= nums[i] <= 100

回溯。
时间复杂度 O(n*2^n)
相似题目: 90. 子集 II
https://leetcode.cn/problems/subsets-ii/
 */