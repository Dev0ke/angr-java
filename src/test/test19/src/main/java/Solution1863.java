import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1863 {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> subsets = solution78subsets(nums);
        int cnt = 0;
        for (List<Integer> subset : subsets) {
            if (subset.size() != 0) {
                int sum = subset.get(0);
                for (int i = 1; i < subset.size(); i++) {
                    sum ^= subset.get(i);
                }
                cnt += sum;
            }
        }
        return cnt;
    }

    private List<List<Integer>> solution78subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0) {
            return resList;
        }
        helper(nums, 0, new LinkedList<>(), resList);
        return resList;
    }

    private void helper(int[] nums, int idx, LinkedList<Integer> subset, List<List<Integer>> resList) {
        if (idx == nums.length) {
            // 副本
            resList.add(new ArrayList<>(subset));
        } else if (idx < nums.length) {
            helper(nums, idx + 1, subset, resList);
            subset.add(nums[idx]);
            helper(nums, idx + 1, subset, resList);
            subset.removeLast();
        }
    }
}
/*
1863. 找出所有子集的异或总和再求和
https://leetcode.cn/problems/sum-of-all-subset-xor-totals/

第 241 场周赛 T1。

一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
- 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
注意：在本题中，元素 相同 的不同子集应 多次 计数。
数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
提示：
1 <= nums.length <= 12
1 <= nums[i] <= 20

基于第 78 题 https://leetcode.cn/problems/subsets/
子集回溯法。时间复杂度 O(2^n)
 */