public class Solution1381 {
    static class CustomStack {
        int[] st, diff;
        int top;

        public CustomStack(int maxSize) {
            st = new int[maxSize];
            diff = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            if (top != st.length - 1) {
                ++top;
                st[top] = x;
            }
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            int res = st[top] + diff[top];
            if (top != 0) {
                diff[top - 1] += diff[top];
            }
            diff[top] = 0;
            --top;
            return res;
        }

        public void increment(int k, int val) {
            int limit = Math.min(k - 1, top);
            if (limit >= 0) {
                diff[limit] += val;
            }
        }
    }
}
/*
1381. 设计一个支持增量操作的栈
https://leetcode.cn/problems/design-a-stack-with-increment-operation/description/

请你设计一个支持对其元素进行增量操作的栈。
实现自定义栈类 CustomStack ：
- CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量。
- void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
- int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
- void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
提示：
1 <= maxSize, x, k <= 1000
0 <= val <= 100
每种方法 increment，push 以及 pop 分别最多调用 1000 次

数组模拟 + 差分思想。
时间复杂度 O(1)。
 */