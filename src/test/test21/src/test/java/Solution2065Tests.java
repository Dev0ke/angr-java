import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2065Tests {
    private final Solution2065 solution2065 = new Solution2065();

    @Test
    public void example1() {
        int[] values = {0, 32, 10, 43};
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,15],[0,3,10]]");
        int maxTime = 49;
        int expected = 75;
        Assertions.assertEquals(expected, solution2065.maximalPathQuality(values, edges, maxTime));
    }

    @Test
    public void example2() {
        int[] values = {5, 10, 15, 20};
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,10],[0,3,10]]");
        int maxTime = 30;
        int expected = 25;
        Assertions.assertEquals(expected, solution2065.maximalPathQuality(values, edges, maxTime));
    }

    @Test
    public void example3() {
        int[] values = {1, 2, 3, 4};
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,11],[2,3,12],[1,3,13]]");
        int maxTime = 50;
        int expected = 7;
        Assertions.assertEquals(expected, solution2065.maximalPathQuality(values, edges, maxTime));
    }

    @Test
    public void example4() {
        int[] values = {0, 1, 2};
        int[][] edges = UtUtils.stringToInts2("[[1,2,10]]");
        int maxTime = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution2065.maximalPathQuality(values, edges, maxTime));
    }
}
