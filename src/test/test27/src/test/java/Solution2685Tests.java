import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2685Tests {
    private final Solution2685 solution2685 = new Solution2685();

    @Test
    public void example1() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2],[3,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2685.countCompleteComponents(n, edges));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,2],[3,4],[3,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2685.countCompleteComponents(n, edges));
    }
}