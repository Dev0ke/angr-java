import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2852Tests {
    private final SolutionP2852 solutionP2852 = new SolutionP2852();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[-1,1,-1],[5,-1,4],[-1,3,-1]]");
        long expected = 39;
        Assertions.assertEquals(expected, solutionP2852.sumRemoteness(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[-1,3,4],[-1,-1,-1],[3,-1,-1]]");
        long expected = 13;
        Assertions.assertEquals(expected, solutionP2852.sumRemoteness(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2852.sumRemoteness(grid));
    }
}