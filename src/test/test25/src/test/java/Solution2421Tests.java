import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2421Tests {
    private final Solution2421 solution2421 = new Solution2421();

    @Test
    public void example1() {
        int[] vals = {1, 3, 2, 1, 3};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[2,4]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution2421.numberOfGoodPaths(vals, edges));
    }

    @Test
    public void example2() {
        int[] vals = {1, 1, 2, 2, 3};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[2,4]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution2421.numberOfGoodPaths(vals, edges));
    }

    @Test
    public void example3() {
        int[] vals = {1};
        int[][] edges = UtUtils.stringToInts2("[]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2421.numberOfGoodPaths(vals, edges));
    }
}
