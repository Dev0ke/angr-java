import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3033Tests {
    private final Solution3033 solution3033 = new Solution3033();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,-1],[4,-1,6],[7,8,9]]");
        int[][] expected = UtUtils.stringToInts2("[[1,2,9],[4,8,6],[7,8,9]]");
        Assertions.assertArrayEquals(expected, solution3033.modifiedMatrix(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[3,-1],[5,2]]");
        int[][] expected = UtUtils.stringToInts2("[[3,2],[5,2]]");
        Assertions.assertArrayEquals(expected, solution3033.modifiedMatrix(matrix));
    }
}