import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP2282 {
    public int[][] seePeople(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            int[] cur = canSeePersonsCount(heights[i]);
            for (int j = 0; j < n; j++) {
                ans[i][j] += cur[j];
            }
        }
        for (int j = 0; j < n; j++) {
            int[] col = new int[m];
            for (int i = 0; i < m; i++) col[i] = heights[i][j];

            int[] cur = canSeePersonsCount(col);
            for (int i = 0; i < m; i++) {
                ans[i][j] += cur[i];
            }
        }

        return ans;
    }

    private int[] canSeePersonsCount(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() < a[i]) { // 必须要严格小于才不会被挡住
                res[i]++;
                st.pop();
            }
            if (!st.isEmpty()) res[i]++;
            while (!st.isEmpty() && st.peek() == a[i]) st.pop(); // 相等的全部出栈
            st.push(a[i]);
        }
        return res;
    }
}
/*
$2282. 在一个网格中可以看到的人数
https://leetcode.cn/problems/number-of-people-that-can-be-seen-in-a-grid/description/

给定一个 m x n 下标从 0 开始的二维正整数数组 heights，其中 heights[i][j] 是站在位置 (i, j) 上的人的高度。
站在 (row1, col1) 位置的人可以看到站在 (row2, col2) 位置的人，前提是:
- (row2, col2) 的人在 (row1, col1) 的人的右边 或 下面。更正式地说，要么 row1 == row2 时 col1 < col2，要么 row1 < row2 时 col1 == col2。
- 他们中间的人 都 比他们两个矮。
返回一个 m x n 的二维整数数组answer，其中 answer[i][j] 是位于 (i, j) 位置的人可以看到的人数。
提示:
1 <= heights.length <= 400
1 <= heights[i].length <= 400
1 <= heights[i][j] <= 10^5

单调栈。
在 1944 的基础上改一下，注意细节
相似题目: 1944. 队列中可以看到的人数
https://leetcode.cn/problems/number-of-visible-people-in-a-queue/
 */