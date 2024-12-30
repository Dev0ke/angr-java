import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2316Tests {
    private final Solution2316 solution2316 = new Solution2316();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution2316.countPairs(n, edges));
    }

    @Test
    public void example2() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,2],[0,5],[2,4],[1,6],[5,4]]");
        long expected = 14;
        Assertions.assertEquals(expected, solution2316.countPairs(n, edges));
    }
}
