import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution913Tests {
    private final Solution913 solution913 = new Solution913();

    @Test
    public void example1() {
        int[][] graph = UtUtils.stringToInts2("[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution913.catMouseGame(graph));
    }

    @Test
    public void example2() {
        int[][] graph = UtUtils.stringToInts2("[[1,3],[0],[3],[0,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution913.catMouseGame(graph));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/291165285/
        // 52 / 56 个通过测试用例
        int[][] graph = UtUtils.stringToInts2("[[5,7,9],[3,4,5,6],[3,4,5,8],[1,2,6,7],[1,2,5,7,9],[0,1,2,4,8],[1,3,7,8],[0,3,4,6,8],[2,5,6,7,9],[0,4,8]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution913.catMouseGame(graph));
    }
}