import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1168Tests {
    private final SolutionP1168 solutionP1168 = new SolutionP1168();

    @Test
    public void example1() {
        int n = 3;
        int[] wells = {1, 2, 2};
        int[][] pipes = UtUtils.stringToInts2("[[1,2,1],[2,3,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1168.minCostToSupplyWater(n, wells, pipes));
    }

    @Test
    public void example2() {
        int n = 2;
        int[] wells = {1, 1};
        int[][] pipes = UtUtils.stringToInts2("[[1,2,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1168.minCostToSupplyWater(n, wells, pipes));
    }
}
