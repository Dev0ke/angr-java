import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2392 {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 拓扑排序
        int[] rowTopo = topo(k, rowConditions);
        if (rowTopo.length == 0) {
            return new int[0][];
        }
        int[] colTopo = topo(k, colConditions);
        if (colTopo.length == 0) {
            return new int[0][];
        }

        // 预处理坐标
        int[] rowIdx = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowIdx[rowTopo[i]] = i;
        }
        int[] colIdx = new int[k + 1];
        for (int i = 0; i < k; i++) {
            colIdx[colTopo[i]] = i;
        }

        // 生成答案
        int[][] ans = new int[k][k];
        for (int num = 1; num <= k; num++) {
            ans[rowIdx[num]][colIdx[num]] = num;
        }
        return ans;
    }

    private int[] topo(int k, int[][] conditions) {
        // 拓扑排序
        Map<Integer, List<Integer>> outGraph = new HashMap<>();
        // 两个数组里的整数都是 1 到 k 之间的数字。
        int[] inDegrees = new int[k + 1];

        // 其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
        for (int[] prerequisite : conditions) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            outGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            inDegrees[to]++;
        }

        // 入度为 0 进队列。记为 0 到 numCourses - 1
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            resList.add(cur);

            for (int next : outGraph.getOrDefault(cur, new ArrayList<>())) {
                inDegrees[next]--;
                if (inDegrees[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (resList.size() == k) {
            return resList.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }
}
/*
2392. 给定条件下构造矩阵
https://leetcode.cn/problems/build-a-matrix-with-conditions/

第 308 场周赛 T4。

给你一个 正 整数 k ，同时给你：
- 一个大小为 n 的二维整数数组 rowConditions ，其中 rowConditions[i] = [abovei, belowi] 和
- 一个大小为 m 的二维整数数组 colConditions ，其中 colConditions[i] = [lefti, righti] 。
两个数组里的整数都是 1 到 k 之间的数字。
你需要构造一个 k x k 的矩阵，1 到 k 每个数字需要 恰好出现一次 。剩余的数字都是 0 。
矩阵还需要满足以下条件：
- 对于所有 0 到 n - 1 之间的下标 i ，数字 abovei 所在的 行 必须在数字 belowi 所在行的上面。
- 对于所有 0 到 m - 1 之间的下标 i ，数字 lefti 所在的 列 必须在数字 righti 所在列的左边。
返回满足上述要求的 任意 矩阵。如果不存在答案，返回一个空的矩阵。
提示：
2 <= k <= 400
1 <= rowConditions.length, colConditions.length <= 10^4
rowConditions[i].length == colConditions[i].length == 2
1 <= abovei, belowi, lefti, righti <= k
abovei != belowi
lefti != righti

对行和列分别拓扑排序，再构造 k*k 矩阵即可。
时间复杂度 O(k^2) 上界为最后构造答案的时间复杂度。
 */