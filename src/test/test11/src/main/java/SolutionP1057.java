import java.util.PriorityQueue;

public class SolutionP1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;

        // 如果有多个 (workeri, bikej) 对之间的 曼哈顿距离 相同，那么我们选择 工人索引最小 的那对。类似地，如果有多种不同的分配方法，则选择 自行车索引最小 的一对。
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.manhattan == o2.manhattan) {
                if (o1.i == o2.i) {
                    return Integer.compare(o1.j, o2.j);
                }
                return Integer.compare(o1.i, o2.i);
            }
            return Integer.compare(o1.manhattan, o2.manhattan);
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int manhattan = manhattan(workers[i], bikes[j]);
                priorityQueue.add(new Node(i, j, manhattan));
            }
        }

        int[] res = new int[n];
        boolean[] usedI = new boolean[n];
        boolean[] usedJ = new boolean[m];
        // 已分配的自行车
        int idx = 0;
        while (idx < n) {
            Node node = priorityQueue.remove();
            // 不断弹出距离最近的，如果符合要求则记录
            if (!usedI[node.i] && !usedJ[node.j]) {
                usedI[node.i] = true;
                usedJ[node.j] = true;
                res[node.i] = node.j;
                idx++;
            }
        }
        return res;
    }

    private int manhattan(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private static class Node {
        int i;
        int j;
        int manhattan;

        public Node(int i, int j, int manhattan) {
            this.i = i;
            this.j = j;
            this.manhattan = manhattan;
        }
    }
}
/*
$1057. 校园自行车分配
https://leetcode.cn/problems/campus-bikes/

在 X-Y 平面上表示的校园中，有 n 名工人和 m 辆自行车，其中 n <= m。
给定一个长度为 n 的数组 workers ，其中 worker [i] = [xi, yi] 表示第 i 个工人的位置。
你也得到一个长度为 m 的自行车数组 bikers ，其中 bikes[j] = [xj, yj] 是第 j 辆自行车的位置。所有给定的位置都是 唯一 的。
我们需要为每位工人分配一辆自行车。在所有可用的自行车和工人中，我们选取彼此之间 曼哈顿距离 最短的工人自行车对 (workeri, bikej) ，并将其中的自行车分配給工人。
如果有多个 (workeri, bikej) 对之间的 曼哈顿距离 相同，那么我们选择 工人索引最小 的那对。
类似地，如果有多种不同的分配方法，则选择 自行车索引最小 的一对。不断重复这一过程，直到所有工人都分配到自行车为止。
返回长度为 n 的向量 answer，其中 answer[i] 是第 i 位工人分配到的自行车的索引（从 0 开始）。
给定两点 p1 和 p2 之间的 曼哈顿距离 为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。
提示：
n == workers.length
m == bikes.length
1 <= n <= m <= 1000
workers[i].length == bikes[j].length == 2
0 <= xi, yi < 1000
0 <= xj, yj < 1000
所有工人和自行车的位置都不相同

相似题目: 1066. 校园自行车分配 II
https://leetcode.cn/problems/campus-bikes-ii/
 */