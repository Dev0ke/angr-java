import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP1548Tests {
    private final SolutionP1548 solutionP1548 = new SolutionP1548();

    @Test
    public void example1() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,2],[0,3],[1,2],[1,3],[1,4],[2,4]]");
        String[] names = {"ATL", "PEK", "LAX", "DXB", "HND"};
        String[] targetPath = {"ATL", "DXB", "HND", "LAX"};
        // [0,2,4,2], [0,3,0,2] 和 [0,3,1,2] 都是正确答案。
        List<Integer> expected = List.of(0, 3, 0, 2);
        Assertions.assertEquals(expected, solutionP1548.mostSimilar(n, roads, names, targetPath));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] roads = UtUtils.stringToInts2("[[1,0],[2,0],[3,0],[2,1],[3,1],[3,2]]");
        String[] names = {"ATL", "PEK", "LAX", "DXB"};
        String[] targetPath = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX"};
//        List<Integer> expected = List.of(0, 1, 0, 1, 0, 1, 0, 1);
        List<Integer> expected = List.of(1, 0, 1, 0, 1, 0, 1, 0);
        Assertions.assertEquals(expected, solutionP1548.mostSimilar(n, roads, names, targetPath));
    }

    @Test
    public void example3() {
        int n = 6;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[4,5]]");
        String[] names = {"ATL", "PEK", "LAX", "ATL", "DXB", "HND"};
        String[] targetPath = {"ATL", "DXB", "HND", "DXB", "ATL", "LAX", "PEK"};
        List<Integer> expected = List.of(3, 4, 5, 4, 3, 2, 1);
        Assertions.assertEquals(expected, solutionP1548.mostSimilar(n, roads, names, targetPath));
    }
}