import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    // 二进制枚举
    static class V1 {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int mask = 0; mask < 1 << n; mask++) {
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 1) {
                        res.add(nums[i]);
                    }
                }
                ans.add(res);
            }
            return ans;
        }
    }

    // 回溯
    static class V2 {
        private int[] nums;
        private List<Integer> res;
        private List<List<Integer>> ans;

        public List<List<Integer>> subsets(int[] nums) {
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
            dfs(i + 1);
            // 选
            res.add(nums[i]);
            dfs(i + 1);
            res.remove(res.size() - 1);
        }
    }
}
/*
78. 子集
https://leetcode.cn/problems/subsets/

给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同

回溯法。
时间复杂度 O(2^n)
 */