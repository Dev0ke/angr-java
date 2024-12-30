import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2282Tests {
    private final SolutionP2282 solutionP2282 = new SolutionP2282();

    @Test
    public void example1() {
        int[][] heights = UtUtils.stringToInts2("[[3,1,4,2,5]]");
        int[][] expected = UtUtils.stringToInts2("[[2,1,2,1,0]]");
        Assertions.assertArrayEquals(expected, solutionP2282.seePeople(heights));
    }

    @Test
    public void example2() {
        int[][] heights = UtUtils.stringToInts2("[[5,1],[3,1],[4,1]]");
        int[][] expected = UtUtils.stringToInts2("[[3,1],[2,1],[1,0]]");
        Assertions.assertArrayEquals(expected, solutionP2282.seePeople(heights));
    }
}