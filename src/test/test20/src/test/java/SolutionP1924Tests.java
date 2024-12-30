import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1924Tests {
    private final SolutionP1924 solutionP1924 = new SolutionP1924();

    @Test
    public void example1() {
        int[][] trees = UtUtils.stringToInts2("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]");
        double[] expected = {2.00000, 2.00000, 2.00000};
        Assertions.assertArrayEquals(expected, solutionP1924.outerTrees(trees));
    }

    @Test
    public void example2() {
        int[][] trees = UtUtils.stringToInts2("[[1,2],[2,2],[4,2]]");
        double[] expected = {2.50000, 2.00000, 1.50000};
        Assertions.assertArrayEquals(expected, solutionP1924.outerTrees(trees));
    }
}