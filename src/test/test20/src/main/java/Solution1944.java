import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        // 单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                // 单调栈中比自己低的都能看到
                res[i]++;
                stack.pop();
            }
            if (!stack.isEmpty()) {
                // 能看到一个比自己高的
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
}
/*
1944. 队列中可以看到的人数
https://leetcode.cn/problems/number-of-visible-people-in-a-queue/

第 57 场双周赛 T4。

有 n 个人排成一个队列，从左到右 编号为 0 到 n - 1 。给你以一个整数数组 heights ，每个整数 互不相同，heights[i] 表示第 i 个人的高度。
一个人能 看到 他右边另一个人的条件是这两人之间的所有人都比他们两人 矮 。
更正式的，第 i 个人能看到第 j 个人的条件是 i < j 且 min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]) 。
请你返回一个长度为 n 的数组 answer ，其中 answer[i] 是第 i 个人在他右侧队列中能 看到 的 人数 。
提示：
n == heights.length
1 <= n <= 10^5
1 <= heights[i] <= 10^5
heights 中所有数 互不相同 。

单调栈。
相似题目: $2282. 在一个网格中可以看到的人数
https://leetcode.cn/problems/number-of-people-that-can-be-seen-in-a-grid/description/
 */