import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2713Tests {
    private final Solution2713 solution2713 = new Solution2713();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[3,1],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells2(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells2(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[3,1,6],[-9,5,7]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution2713.maxIncreasingCells2(mat));
    }
}