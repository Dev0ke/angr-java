import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2128Tests {
    private final SolutionP2128 solutionP2128 = new SolutionP2128();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[1,0,1],[0,1,0]]");
        Assertions.assertTrue(solutionP2128.removeOnes(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0],[0,0,0],[0,0,0]]");
        Assertions.assertFalse(solutionP2128.removeOnes(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0]]");
        Assertions.assertTrue(solutionP2128.removeOnes(grid));
    }
}