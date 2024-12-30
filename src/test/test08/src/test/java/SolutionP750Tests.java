import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP750Tests {
    private final SolutionP750 solutionP750 = new SolutionP750();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,1,0],[0,0,1,0,1],[0,0,0,1,0],[1,0,1,0,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP750.countCornerRectangles(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[1,1,1]]");
        int expected = 9;
        Assertions.assertEquals(expected, solutionP750.countCornerRectangles(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP750.countCornerRectangles(grid));
    }
}
