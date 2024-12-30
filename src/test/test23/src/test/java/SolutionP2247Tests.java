import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2247Tests {
    private final SolutionP2247 solutionP2247 = new SolutionP2247();

    @Test
    public void example1() {
        int n = 5;
        int[][] highways = UtUtils.stringToInts2("[[0,1,4],[2,1,3],[1,4,11],[3,2,3],[3,4,2]]");
        int k = 3;
        int expected = 17;
        Assertions.assertEquals(expected, solutionP2247.maximumCost(n, highways, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] highways = UtUtils.stringToInts2("[[0,1,3],[2,3,2]]");
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2247.maximumCost(n, highways, k));
    }
}