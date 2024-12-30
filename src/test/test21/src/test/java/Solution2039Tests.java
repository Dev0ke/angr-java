import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2039Tests {
    private final Solution2039 solution2039 = new Solution2039();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] patience = {0, 2, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solution2039.networkBecomesIdle(edges, patience));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2]]");
        int[] patience = {0, 10, 10};
        int expected = 3;
        Assertions.assertEquals(expected, solution2039.networkBecomesIdle(edges, patience));
    }
}