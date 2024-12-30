import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    private int[] nums;
    private List<Integer> res;
    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        res = new ArrayList<>();
        ans = new ArrayList<>();
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        // 不选
        dfs(getNext(i));
        // 选
        res.add(nums[i]);
        dfs(i + 1);
        res.remove(res.size() - 1);
    }

    private int getNext(int i) {
        int st = i;
        for (i++; i < nums.length && nums[i] == nums[st]; i++) {
        }
        return i;
    }
}
/*
90. 子集 II
https://leetcode.cn/problems/subsets-ii/

给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10

思路类似 第 39 题与第 40 题差异，Arrays.sort() + getNext() 去重同理
时间复杂度 O(n * 2^n)
相似题目: 78. 子集
https://leetcode.cn/problems/subsets/
39. 组合总和
https://leetcode.cn/problems/combination-sum/
40. 组合总和 II
https://leetcode.cn/problems/combination-sum-ii/
491. 非递减子序列
https://leetcode.cn/problems/non-decreasing-subsequences/description/
 */