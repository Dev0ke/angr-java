import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2642Tests {
    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]");
        Solution2642.Graph g = new Solution2642.Graph(4, edges);

        // 返回 6 。从 3 到 2 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 + 2 + 1 = 6 。
        Assertions.assertEquals(6, g.shortestPath(3, 2));

        // 返回 -1 。没有从 0 到 3 的路径。
        Assertions.assertEquals(-1, g.shortestPath(0, 3));

        // 添加一条节点 1 到节点 3 的边，得到第二幅图。
        g.addEdge(new int[]{1, 3, 4});

        // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
        Assertions.assertEquals(6, g.shortestPath(0, 3));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]");
        Solution2642.Graph2 g = new Solution2642.Graph2(4, edges);

        // 返回 6 。从 3 到 2 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 + 2 + 1 = 6 。
        Assertions.assertEquals(6, g.shortestPath(3, 2));

        // 返回 -1 。没有从 0 到 3 的路径。
        Assertions.assertEquals(-1, g.shortestPath(0, 3));

        // 添加一条节点 1 到节点 3 的边，得到第二幅图。
        g.addEdge(new int[]{1, 3, 4});

        // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
        Assertions.assertEquals(6, g.shortestPath(0, 3));
    }
}