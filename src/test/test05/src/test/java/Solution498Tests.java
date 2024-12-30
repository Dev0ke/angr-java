import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution498Tests {
    private final Solution498 solution498 = new Solution498();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] expected = {1, 2, 4, 7, 5, 3, 6, 8, 9};
        Assertions.assertArrayEquals(expected, solution498.findDiagonalOrder(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution498.findDiagonalOrder(mat));
    }
}