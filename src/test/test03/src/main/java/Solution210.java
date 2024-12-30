import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 拓扑排序
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[numCourses];

        // 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            inDeg[to]++;
        }

        // 入度为 0 进队列。记为 0 到 numCourses - 1
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.remove();
            resList.add(x);

            for (int y : adj.getOrDefault(x, new ArrayList<>())) {
                inDeg[y]--;
                if (inDeg[y] == 0) {
                    queue.add(y);
                }
            }
        }
        if (resList.size() == numCourses) {
            return resList.stream().mapToInt(i -> i).toArray();
        }
        return new int[]{};
    }
}
/*
210. 课程表 II
https://leetcode.cn/problems/course-schedule-ii/

现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，
表示在选修课程 ai 前 必须 先选修 bi 。
例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
提示：
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
所有[ai, bi] 互不相同

拓扑排序。
相似题目: 207. 课程表
https://leetcode.cn/problems/course-schedule/
 */