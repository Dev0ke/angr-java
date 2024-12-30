import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP694Tests {
    private final SolutionP694 solutionP694 = new SolutionP694();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP694.numDistinctIslands(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP694.numDistinctIslands(grid));
    }
}
