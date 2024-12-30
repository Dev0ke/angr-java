import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2655Tests {
    private final SolutionP2655 solutionP2655 = new SolutionP2655();

    @Test
    public void example1() {
        int n = 10;
        int[][] ranges = UtUtils.stringToInts2("[[3,5],[7,8]]");
        int[][] expected = UtUtils.stringToInts2("[[0,2],[6,6],[9,9]]");
        Assertions.assertArrayEquals(expected, solutionP2655.findMaximalUncoveredRanges(n, ranges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] ranges = UtUtils.stringToInts2("[[0,2]]");
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solutionP2655.findMaximalUncoveredRanges(n, ranges));
    }

    @Test
    public void example3() {
        int n = 7;
        int[][] ranges = UtUtils.stringToInts2("[[2,4],[0,3]]");
        int[][] expected = UtUtils.stringToInts2("[[5,6]]");
        Assertions.assertArrayEquals(expected, solutionP2655.findMaximalUncoveredRanges(n, ranges));
    }
}