import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        helper(nums, 0, resList);
        return resList;
    }

    private void helper(int[] nums, int i, List<List<Integer>> resList) {
        if (i == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            resList.add(permutation);
        } else {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    this.swap(nums, i, j);
                    helper(nums, i + 1, resList);
                    this.swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
/*
47. 全排列 II
https://leetcode.cn/problems/permutations-ii/

给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10

第 46 题升级版。可包含重复数字。
回溯法。
相似题目: 46. 全排列
https://leetcode.cn/problems/permutations/
 */
