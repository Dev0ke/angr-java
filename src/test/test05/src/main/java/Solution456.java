import java.util.ArrayDeque;
import java.util.Deque;

public class Solution456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        // 右往左
        stack.push(nums[n - 1]);
        int max = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < max) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max = stack.pop();
            }
            if (nums[i] > max) {
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
/*
456. 132 模式
https://leetcode.cn/problems/132-pattern/

给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
提示：
n == nums.length
1 <= n <= 2 * 10^5
-10^9 <= nums[i] <= 10^9

单调栈 枚举 i
时间复杂度 O(n)
空间复杂度 O(n)
 */