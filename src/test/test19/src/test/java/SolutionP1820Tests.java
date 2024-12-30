import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1820Tests {
    private final SolutionP1820 solutionP1820 = new SolutionP1820();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1820.maximumInvitations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1,0],[1,0,0,0],[0,0,1,0],[1,1,1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1820.maximumInvitations(grid));
    }
}