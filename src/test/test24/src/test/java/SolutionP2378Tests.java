import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2378Tests {
    private final SolutionP2378 solutionP2378 = new SolutionP2378();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[-1,-1],[0,5],[0,10],[2,6],[2,4]]");
        long expected = 11;
        Assertions.assertEquals(expected, solutionP2378.maxScore(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[-1,-1],[0,5],[0,-6],[0,7]]");
        long expected = 7;
        Assertions.assertEquals(expected, solutionP2378.maxScore(edges));
    }
}