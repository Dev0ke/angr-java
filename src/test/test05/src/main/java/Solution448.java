import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> resSet = new HashSet<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            resSet.add(i);
        }
        for (int num : nums) {
            resSet.remove(num);
        }
        return new ArrayList<>(resSet);
    }
}
/*
448. 找到所有数组中消失的数字
https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/

给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
提示：
n == nums.length
1 <= n <= 10^5
1 <= nums[i] <= n
进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。

模拟。
 */