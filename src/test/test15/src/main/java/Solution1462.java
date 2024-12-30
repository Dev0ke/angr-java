import java.util.ArrayList;
import java.util.List;

public class Solution1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] g = new boolean[numCourses][numCourses];
        for (int[] p : prerequisites) {
            int x = p[0], y = p[1];
            g[x][y] = true;
        }
        // Floyd
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    g[i][j] |= g[i][k] && g[k][j];
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] p : queries) {
            int x = p[0], y = p[1];
            ans.add(g[x][y]);
        }
        return ans;
    }
}
/*
1462. 课程表 IV
https://leetcode.cn/problems/course-schedule-iv/

第 27 场双周赛 T3。

你总共需要上 n 门课，课程编号依次为 0 到 n-1 。
- 有的课会有直接的先修课程，比如如果想上课程 0 ，你必须先上课程 1 ，那么会以 [1,0] 数对的形式给出先修课程数对。
给你课程总数 n 和一个直接先修课程数对列表 prerequisite 和一个查询对列表 queries 。
对于每个查询对 queries[i] ，请判断 queries[i][0] 是否是 queries[i][1] 的先修课程。
请返回一个布尔值列表，列表中每个元素依次分别对应 queries 每个查询对的判断结果。
注意：如果课程 a 是课程 b 的先修课程且课程 b 是课程 c 的先修课程，那么课程 a 也是课程 c 的先修课程。
提示：
2 <= n <= 100
0 <= prerequisite.length <= (n * (n - 1) / 2)
0 <= prerequisite[i][0], prerequisite[i][1] < n
prerequisite[i][0] != prerequisite[i][1]
先修课程图中没有环。
先修课程图中没有重复的边。
1 <= queries.length <= 10^4
queries[i][0] != queries[i][1]

这道题的数据范围尤其重要。
如果参考 2101 题，直接建图，逐个查询 bfs，时间复杂度为 O(k^2)（k 为查询次数）10^8 将会超时。
参考 743 题，floyd 三层循环，时间复杂度为 O(n^3) 10^6 可以接受的范围。
相似题目: 743. 网络延迟时间
https://leetcode.cn/problems/network-delay-time/
 */