import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2174Tests {
    private final SolutionP2174 solutionP2174 = new SolutionP2174();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[0,1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2174.removeOnes(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[1,0,1],[0,1,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2174.removeOnes(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,0],[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2174.removeOnes(grid));
    }
}