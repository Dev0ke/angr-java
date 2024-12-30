import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2500Tests {
    private final Solution2500 solution2500 = new Solution2500();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,4],[3,3,1]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution2500.deleteGreatestValue(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[10]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution2500.deleteGreatestValue(grid));
    }
}
