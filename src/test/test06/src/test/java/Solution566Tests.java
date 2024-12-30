import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution566Tests {
    private final Solution566 solution566 = new Solution566();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int r = 1;
        int c = 4;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3,4]]");
        Assertions.assertArrayEquals(expected, solution566.matrixReshape(mat, r, c));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int r = 2;
        int c = 4;
        int[][] expected = UtUtils.stringToInts2("[[1,2],[3,4]]");
        Assertions.assertArrayEquals(expected, solution566.matrixReshape(mat, r, c));
    }
}
