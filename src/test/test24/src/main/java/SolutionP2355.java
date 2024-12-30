import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP2355 {
    public long maximumBooks(int[] books) {
        int n = books.length;
        // 定义 f[i] 表示以 books[i] 结尾时取到的书的最大值
        long ans = 0;
        // 单调栈存 下标，dp 值
        Deque<Node> st = new ArrayDeque<>();
        st.push(new Node(-1, 0));
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && books[st.peek().i] - st.peek().i >= books[i] - i) {
                st.pop();
            }
            long size = Math.min(i - st.peek().i, books[i]);
            long sum = (books[i] * 2L - size + 1) * size / 2 + st.peek().f;
            ans = Math.max(ans, sum);
            st.push(new Node(i, sum));
        }
        return ans;
    }

    static class Node {
        int i;
        long f;

        public Node(int i, long f) {
            this.i = i;
            this.f = f;
        }
    }
}
/*
$2355. 你能拿走的最大图书数量
https://leetcode.cn/problems/maximum-number-of-books-you-can-take/description/

给定一个长度为 n 的 下标从 0 开始 的整数数组 books，其中 books[i] 表示书架的第 i 个书架上的书的数量。
你要从书架 l 到 r 的一个 连续 的部分中取书，其中 0 <= l <= r < n。对于 l <= i < r 范围内的每个索引 i，你从书架 i 取书的数量必须 严格小于 你从书架 i + 1 取书的数量。
返回你能从书架上拿走的书的 最大 数量。
提示:
1 <= books.length <= 10^5
0 <= books[i] <= 10^5

单调栈 + DP + 一次遍历。
https://leetcode.cn/problems/maximum-number-of-books-you-can-take/solutions/1704892/dan-diao-zhan-dp-by-endlesscheng-9d6y/
时间复杂度 O(n)。
 */