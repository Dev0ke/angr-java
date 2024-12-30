import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2289 {
    public int totalSteps(int[] nums) {
        int ans = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        for (var num : nums) {
            int maxT = 0;
            while (!stack.isEmpty() && stack.peek()[0] <= num) {
                maxT = Math.max(maxT, stack.peek()[1]);
                stack.pop();
            }
            if (!stack.isEmpty()) {
                maxT++;
            }
            ans = Math.max(ans, maxT);
            stack.push(new int[]{num, maxT});
        }
        return ans;
    }
}
/*
2289. 使数组按非递减顺序排列
https://leetcode.cn/problems/steps-to-make-array-non-decreasing/

第 295 场周赛 T3。

给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。
重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

单调栈
时间复杂度 O(n)
 */