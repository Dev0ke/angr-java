import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2387Tests {
    private final SolutionP2387 solutionP2387 = new SolutionP2387();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,2],[2,3,3],[1,3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2387.matrixMedian(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,3,3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2387.matrixMedian(grid));
    }
}