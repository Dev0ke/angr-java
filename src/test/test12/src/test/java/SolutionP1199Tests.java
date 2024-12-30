import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1199Tests {
    private final SolutionP1199 solutionP1199 = new SolutionP1199();

    @Test
    public void example1() {
        int[] blocks = {1};
        int split = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1199.minBuildTime(blocks, split));
    }

    @Test
    public void example2() {
        int[] blocks = {1, 2};
        int split = 5;
        int expected = 7;
        Assertions.assertEquals(expected, solutionP1199.minBuildTime(blocks, split));
    }

    @Test
    public void example3() {
        int[] blocks = {1, 2, 3};
        int split = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1199.minBuildTime(blocks, split));
    }
}