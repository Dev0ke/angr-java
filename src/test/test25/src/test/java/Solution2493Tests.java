import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2493Tests {
    private final Solution2493 solution2493 = new Solution2493();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2493.magnificentSets(n, edges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,3],[3,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2493.magnificentSets(n, edges));
    }
}
