import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2371Tests {
    private final SolutionP2371 solutionP2371 = new SolutionP2371();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,1],[2,5]]");
        int[][] expected = UtUtils.stringToInts2("[[2,1],[1,2]]");
        Assertions.assertArrayEquals(expected, solutionP2371.minScore(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[10]]");
        int[][] expected = UtUtils.stringToInts2("[[1]]");
        Assertions.assertArrayEquals(expected, solutionP2371.minScore(grid));
    }
}