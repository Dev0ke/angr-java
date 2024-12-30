import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3142Tests {
    private final Solution3142 solution3142 = new Solution3142();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,2],[1,0,2]]");
        Assertions.assertTrue(solution3142.satisfiesConditions(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[0,0,0]]");
        Assertions.assertFalse(solution3142.satisfiesConditions(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1],[2],[3]]");
        Assertions.assertFalse(solution3142.satisfiesConditions(grid));
    }
}