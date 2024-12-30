import java.util.ArrayDeque;
import java.util.Deque;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;

        int[] res = new int[len];
        // 单调栈 存放数组元素下标而非数组元素
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek() - i;
            } else {
                res[i] = 0;
            }
            stack.push(i);
        }
        return res;
    }
}
/*
739. 每日温度
https://leetcode.cn/problems/daily-temperatures/

给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。
如果气温在这之后都不会升高，请在该位置用 0 来代替。
提示：
1 <= temperatures.length <= 10^5
30 <= temperatures[i] <= 100

单调栈。
解法同第 496、503 题，本题存放数组元素下标而非数组元素
 */