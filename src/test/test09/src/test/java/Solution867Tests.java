import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution867Tests {
    private final Solution867 solution867 = new Solution867();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[][] expected = UtUtils.stringToInts2("[[1,4,7],[2,5,8],[3,6,9]]");
        Assertions.assertArrayEquals(expected, solution867.transpose(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6]]");
        int[][] expected = UtUtils.stringToInts2("[[1,4],[2,5],[3,6]]");
        Assertions.assertArrayEquals(expected, solution867.transpose(matrix));
    }
}
