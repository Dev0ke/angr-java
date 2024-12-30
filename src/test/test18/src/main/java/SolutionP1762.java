import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionP1762 {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                st.pop();
            }
            st.push(i);
        }

        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
/*
$1762. 能看到海景的建筑物
https://leetcode.cn/problems/buildings-with-an-ocean-view/description/

有 n 座建筑物。给你一个大小为 n 的整数数组 heights 表示每一个建筑物的高度。
建筑物的右边是海洋。如果建筑物可以无障碍地看到海洋，则建筑物能看到海景。确切地说，如果一座建筑物右边的所有建筑都比它 矮 时，就认为它能看到海景。
返回能看到海景建筑物的下标列表（下标 从 0 开始 ），并按升序排列。
提示：
1 <= heights.length <= 10^5
1 <= heights[i] <= 10^9

单调栈。
时间复杂度 O(n)。
 */