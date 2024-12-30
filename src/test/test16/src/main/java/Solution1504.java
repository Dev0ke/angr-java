import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1504 {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] pre = new int[m]; // 矩形高度
        int ans = 0;
        for (int[] row : mat) {
            for (int j = 0; j < m; j++) {
                if (row[j] == 0) pre[j] = 0;
                else pre[j] = pre[j] + 1;
            }
            // pre数组就相当于”美丽塔“数组
            Deque<Integer> st = new ArrayDeque<>();
            int sum = 0;
            st.push(-1); // 占位
            for (int j = 0; j < m; j++) {
                while (st.size() > 1 && pre[st.peek()] > pre[j]) {
                    int preIdx = st.pop();
                    sum -= (preIdx - st.peek()) * pre[preIdx]; // 撤销选中
                }
                // 选中
                sum += (j - st.peek()) * (pre[j]);
                ans += sum;
                st.push(j);
            }
        }
        return ans;
    }
}
/*
1504. 统计全 1 子矩形
https://leetcode.cn/problems/count-submatrices-with-all-ones/description/

给你一个 m x n 的二进制矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
提示：
1 <= m, n <= 150
mat[i][j] 仅包含 0 或 1

单调栈。
https://leetcode.cn/problems/count-submatrices-with-all-ones/solutions/336410/tong-ji-quan-1-zi-ju-xing-by-leetcode-solution/comments/2222869
时间复杂度 O(nm)。
相似题目: 2866. 美丽塔 II
https://leetcode.cn/problems/beautiful-towers-ii/
 */