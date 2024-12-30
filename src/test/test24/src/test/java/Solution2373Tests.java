import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2373Tests {
    private final Solution2373 solution2373 = new Solution2373();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]");
        int[][] expected = UtUtils.stringToInts2("[[9,9],[8,6]]");
        Assertions.assertArrayEquals(expected, solution2373.largestLocal(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[2,2,2],[2,2,2],[2,2,2]]");
        Assertions.assertArrayEquals(expected, solution2373.largestLocal(grid));
    }
}
