import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP573Tests {
    private final SolutionP573 solutionP573 = new SolutionP573();

    @Test
    public void example1() {
        int height = 5;
        int width = 7;
        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = UtUtils.stringToInts2("[[3,0], [2,5]]");
        int expected = 12;
        Assertions.assertEquals(expected, solutionP573.minDistance(height, width, tree, squirrel, nuts));
    }
}
