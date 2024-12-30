import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1135Tests {
    private final SolutionP1135 solutionP1135 = new SolutionP1135();

    @Test
    public void example1() {
        int n = 3;
        int[][] connections = UtUtils.stringToInts2("[[1,2,5],[1,3,6],[2,3,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionP1135.minimumCost(n, connections));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] connections = UtUtils.stringToInts2("[[1,2,3],[3,4,4]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1135.minimumCost(n, connections));
    }
}
