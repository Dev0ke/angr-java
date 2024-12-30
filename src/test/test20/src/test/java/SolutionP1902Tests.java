import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1902Tests {
    private final SolutionP1902 solutionP1902 = new SolutionP1902();

    @Test
    public void example1() {
        int[] order = {2, 1, 4, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1902.maxDepthBST(order));
    }

    @Test
    public void example2() {
        int[] order = {2, 1, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1902.maxDepthBST(order));
    }

    @Test
    public void example3() {
        int[] order = {1, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1902.maxDepthBST(order));
    }
}