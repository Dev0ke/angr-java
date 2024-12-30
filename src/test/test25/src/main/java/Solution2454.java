import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2454 {
    public int[] secondGreaterElement(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);

        // 存放下标 i
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        // 从左到右
        for (int i = 0; i < len; i++) {
            while (!stack2.isEmpty() && nums[stack2.peek()] < nums[i]) {
                int pop = stack2.pop();
                res[pop] = nums[i];
            }

            // 借助一个辅助栈实现 "平移"
            Deque<Integer> tmpStack = new ArrayDeque<>();
            while (!stack1.isEmpty() && nums[stack1.peek()] < nums[i]) {
                int pop = stack1.pop();
                tmpStack.push(pop);
            }
            while (!tmpStack.isEmpty()) {
                stack2.push(tmpStack.pop());
            }
            stack1.push(i);
        }
        return res;
    }
}
/*
2454. 下一个更大元素 IV
https://leetcode.cn/problems/next-greater-element-iv/

第 90 场双周赛 T4。

给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
- j > i
- nums[j] > nums[i]
- 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
如果不存在 nums[j] ，那么第二大整数为 -1 。
- 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

由左到右 两次单调栈
时间复杂度 O(n)
相似题目: 496. 下一个更大元素 I
https://leetcode.cn/problems/next-greater-element-i/
 */