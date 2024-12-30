import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP305Tests {
    private final SolutionP305 solutionP305 = new SolutionP305();

    @Test
    public void example1() {
        int m = 3;
        int n = 3;
        int[][] positions = UtUtils.stringToInts2("[[0,0],[0,1],[1,2],[2,1]]");
        List<Integer> expected = List.of(1, 1, 2, 3);
        Assertions.assertEquals(expected, solutionP305.numIslands2(m, n, positions));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 1;
        int[][] positions = UtUtils.stringToInts2("[[0,0]]");
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solutionP305.numIslands2(m, n, positions));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/335531123/
        // positions[i] 可能重复
        int m = 3;
        int n = 3;
        int[][] positions = UtUtils.stringToInts2("[[0,0],[0,1],[1,2],[1,2]]");
        List<Integer> expected = List.of(1, 1, 2, 2);
        Assertions.assertEquals(expected, solutionP305.numIslands2(m, n, positions));
    }
}