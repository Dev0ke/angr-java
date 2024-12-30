import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP562Tests {
    private final SolutionP562 solutionP562 = new SolutionP562();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,0],[0,0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP562.longestLine(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,1,1,1],[0,1,1,0],[0,0,0,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionP562.longestLine(mat));
    }
}
