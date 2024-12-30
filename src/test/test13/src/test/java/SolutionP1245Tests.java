import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1245Tests {
    private final SolutionP1245 solutionP1245 = new SolutionP1245();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1245.treeDiameter(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[1,4],[4,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1245.treeDiameter(edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // 题目说 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边，但却没有看到反向边的用例，如：
        int[][] edges = UtUtils.stringToInts2("[[0,1],[2,1],[2,3],[1,4],[4,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1245.treeDiameter(edges));
    }
}
