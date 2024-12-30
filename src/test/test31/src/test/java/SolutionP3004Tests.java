import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3004Tests {
    private final SolutionP3004 solutionP3004 = new SolutionP3004();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int[] colors = {1, 1, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3004.maximumSubtreeSize(edges, colors));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int[] colors = {1, 1, 1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3004.maximumSubtreeSize(edges, colors));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        int[] colors = {1, 2, 3, 3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3004.maximumSubtreeSize(edges, colors));
    }
}