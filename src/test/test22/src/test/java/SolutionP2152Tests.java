import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2152Tests {
    private final SolutionP2152 solutionP215 = new SolutionP2152();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,1],[2,3],[4,5],[4,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP215.minimumLines(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,2],[-2,-2],[1,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP215.minimumLines(points));
    }
}