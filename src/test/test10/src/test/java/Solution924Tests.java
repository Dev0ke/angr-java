import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution924Tests {
    private final Solution924 solution924 = new Solution924();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[1,1,0],[1,1,0],[0,0,1]]");
        int[] initial = {0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution924.minMalwareSpread(graph, initial));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1,0,0],[0,1,0],[0,0,1]]");
        int[] initial = {0, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution924.minMalwareSpread(graph, initial));
    }

    @Test
    public void example3() {
        int[][] graph = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[1,1,1]]");
        int[] initial = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution924.minMalwareSpread(graph, initial));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/290683132/
        int[][] graph = UtUtils.stringToInts2("[[1,0,0,0],[0,1,0,0],[0,0,1,1],[0,0,1,1]]");
        int[] initial = {3, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution924.minMalwareSpread(graph, initial));
    }
}