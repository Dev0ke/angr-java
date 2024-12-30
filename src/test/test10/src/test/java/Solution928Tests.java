import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution928Tests {
    private final Solution928 solution928 = new Solution928();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,1,0],[1,1,0],[0,0,1]]");
        int[] initial = {0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution928.minMalwareSpread(graph, initial));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1,1,0],[1,1,1],[0,1,1]]");
        int[] initial = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution928.minMalwareSpread(graph, initial));
    }

    @Test
    public void example3() {
        int[][] graph = UtUtils.stringToInts2("[[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]]");
        int[] initial = {0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution928.minMalwareSpread(graph, initial));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/290821674/
        // 存在 find(u) == find(v)
        int[][] graph = UtUtils.stringToInts2("[[1,0,0,0,0,0,0,0,0],[0,1,0,0,0,0,0,0,1],[0,0,1,0,0,0,0,0,0],[0,0,0,1,0,0,0,0,1],[0,0,0,0,1,0,1,1,1],[0,0,0,0,0,1,0,0,1],[0,0,0,0,1,0,1,1,0],[0,0,0,0,1,0,1,1,0],[0,1,0,1,1,1,0,0,1]]");
        int[] initial = {8, 4, 2, 0};
        int expected = 8;
        Assertions.assertEquals(expected, solution928.minMalwareSpread(graph, initial));
    }
}