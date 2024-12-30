import java.util.ArrayDeque;
import java.util.Deque;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i % len] = stack.peek();
            } else {
                res[i % len] = -1;
            }
            stack.push(nums[i % len]);
        }
        return res;
    }
}
/*
503. 下一个更大元素 II
https://leetcode.cn/problems/next-greater-element-ii/

给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
提示:
1 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9

单调栈。
第 496 题升级版。循环数组可用 i % len 下标进行处理
 */