import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1956Tests {
    private final SolutionP1956 solutionP1956 = new SolutionP1956();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[6,1]]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1956.minDayskVariants(points, k));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[3,3],[1,2],[9,2]]");
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1956.minDayskVariants(points, k));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[3,3],[1,2],[9,2]]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1956.minDayskVariants(points, k));
    }
}