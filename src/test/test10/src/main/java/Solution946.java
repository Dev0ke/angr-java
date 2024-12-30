import java.util.ArrayDeque;
import java.util.Deque;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        // 栈模拟
        Deque<Integer> st = new ArrayDeque<>();
        int popIdx = 0;
        for (int push : pushed) {
            st.push(push);
            while (!st.isEmpty() && popIdx < n && st.peek() == popped[popIdx]) {
                st.pop();
                popIdx++;
            }
        }
        return popIdx == n;
    }
}
/*
946. 验证栈序列
https://leetcode.cn/problems/validate-stack-sequences/

第 112 场周赛 T2。

给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
提示：
1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
pushed 的所有元素 互不相同
popped.length == pushed.length
popped 是 pushed 的一个排列

使用栈进行模拟。栈都是按顺序入栈，出栈顺序类似单调栈即可。
 */