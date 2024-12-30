import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2184Tests {
    private final SolutionP2184 solutionP2184 = new SolutionP2184();

    @Test
    public void example1() {
        int height = 2;
        int width = 3;
        int[] bricks = {1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2184.buildWall(height, width, bricks));
    }

    @Test
    public void example2() {
        int height = 1;
        int width = 1;
        int[] bricks = {5};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2184.buildWall(height, width, bricks));
    }
}