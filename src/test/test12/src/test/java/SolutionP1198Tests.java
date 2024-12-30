import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1198Tests {
    private final SolutionP1198 solutionP1198 = new SolutionP1198();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]");
        int expected = 5;
        Assertions.assertEquals(expected, solutionP1198.smallestCommonElement(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3],[2,3,4],[2,3,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1198.smallestCommonElement(mat));
    }
}
