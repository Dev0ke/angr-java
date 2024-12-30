import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP261Tests {
    private final SolutionP261 solutionP261 = new SolutionP261();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,4]]");
        Assertions.assertTrue(solutionP261.validTree(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[1,3],[1,4]]");
        Assertions.assertFalse(solutionP261.validTree(n, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/282658329/
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[2,3]]");
        Assertions.assertFalse(solutionP261.validTree(n, edges));
    }
}