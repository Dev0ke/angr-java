import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2360Tests {
    private final Solution2360 solution2360 = new Solution2360();

    @Test
    public void example1() {
        int[] edges = {3, 3, 4, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2360.longestCycle(edges));
    }

    @Test
    public void example2() {
        int[] edges = {2, -1, 3, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solution2360.longestCycle(edges));
    }
}
