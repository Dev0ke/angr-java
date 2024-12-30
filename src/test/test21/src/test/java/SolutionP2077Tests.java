import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2077Tests {
    private final SolutionP2077 solutionP2077 = new SolutionP2077();

    @Test
    public void example1() {
        int n = 5;
        int[][] corridors = UtUtils.stringToInts2("[[1,2],[5,2],[4,1],[2,4],[3,1],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2077.numberOfPaths(n, corridors));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] corridors = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2077.numberOfPaths(n, corridors));
    }
}