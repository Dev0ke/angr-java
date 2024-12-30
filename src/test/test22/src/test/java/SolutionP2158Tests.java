import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2158Tests {
    private final SolutionP2158 solutionP2158 = new SolutionP2158();

    @Test
    public void example1() {
        int[][] paint = UtUtils.stringToInts2("[[1,4],[4,7],[5,8]]");
        int[] expected = {3, 3, 1};
        Assertions.assertArrayEquals(expected, solutionP2158.amountPainted(paint));
    }

    @Test
    public void example2() {
        int[][] paint = UtUtils.stringToInts2("[[1,4],[5,8],[4,7]]");
        int[] expected = {3, 3, 1};
        Assertions.assertArrayEquals(expected, solutionP2158.amountPainted(paint));
    }

    @Test
    public void example3() {
        int[][] paint = UtUtils.stringToInts2("[[1,5],[2,4]]");
        int[] expected = {4, 0};
        Assertions.assertArrayEquals(expected, solutionP2158.amountPainted(paint));
    }
}