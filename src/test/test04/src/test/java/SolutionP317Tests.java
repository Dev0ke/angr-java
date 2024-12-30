import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP317Tests {
    private final SolutionP317 solutionP317 = new SolutionP317();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]");
        int expected = 7;
        Assertions.assertEquals(expected, solutionP317.shortestDistance(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP317.shortestDistance(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionP317.shortestDistance(grid));
    }
}
