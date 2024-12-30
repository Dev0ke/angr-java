import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2510Tests {
    private final SolutionP2510 solutionP2510 = new SolutionP2510();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0,0],[0,1,0,0],[1,0,1,0]]");
        Assertions.assertTrue(solutionP2510.isThereAPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0],[0,0,1],[1,0,0]]");
        Assertions.assertFalse(solutionP2510.isThereAPath(grid));
    }
}