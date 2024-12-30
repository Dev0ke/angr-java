import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2093Tests {
    private final SolutionP2093 solutionP2093 = new SolutionP2093();

    @Test
    public void example1() {
        int n = 5;
        int[][] highways = UtUtils.stringToInts2("[[0,1,4],[2,1,3],[1,4,11],[3,2,3],[3,4,2]]");
        int discounts = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solutionP2093.minimumCost(n, highways, discounts));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] highways = UtUtils.stringToInts2("[[1,3,17],[1,2,7],[3,2,5],[0,1,6],[3,0,20]]");
        int discounts = 20;
        int expected = 8;
        Assertions.assertEquals(expected, solutionP2093.minimumCost(n, highways, discounts));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] highways = UtUtils.stringToInts2("[[0,1,3],[2,3,2]]");
        int discounts = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2093.minimumCost(n, highways, discounts));
    }
}