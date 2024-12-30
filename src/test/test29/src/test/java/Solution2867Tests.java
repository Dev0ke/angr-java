import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2867Tests {
    private final Solution2867 solution2867 = new Solution2867();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[2,4],[2,5]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution2867.countPaths(n, edges));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[2,4],[3,5],[3,6]]");
        long expected = 6;
        Assertions.assertEquals(expected, solution2867.countPaths(n, edges));
    }
}