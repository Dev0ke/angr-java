import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2397Tests {
    private final Solution2397 solution2397 = new Solution2397();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[1,0,1],[0,1,1],[0,0,1]]");
        int cols = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2397.maximumRows(mat, cols));
        Assertions.assertEquals(expected, solution2397.maximumRows2(mat, cols));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1],[0]]");
        int cols = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2397.maximumRows(mat, cols));
        Assertions.assertEquals(expected, solution2397.maximumRows2(mat, cols));
    }
}
