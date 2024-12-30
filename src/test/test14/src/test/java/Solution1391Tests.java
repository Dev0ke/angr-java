import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1391Tests {
    private final Solution1391 solution1391 = new Solution1391();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,4,3],[6,5,2]]");
        Assertions.assertTrue(solution1391.hasValidPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,1],[1,2,1]]");
        Assertions.assertFalse(solution1391.hasValidPath(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,2]]");
        Assertions.assertFalse(solution1391.hasValidPath(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,1,1,3]]");
        Assertions.assertTrue(solution1391.hasValidPath(grid));
    }

    @Test
    public void example5() {
        int[][] grid = UtUtils.stringToInts2("[[2],[2],[2],[2],[2],[2],[6]]");
        Assertions.assertTrue(solution1391.hasValidPath(grid));
    }
}