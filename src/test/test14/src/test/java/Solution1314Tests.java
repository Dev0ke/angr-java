import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1314Tests {
    private final Solution1314 solution1314 = new Solution1314();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int k = 1;
        int[][] expected = UtUtils.stringToInts2("[[12,21,16],[27,45,33],[24,39,28]]");
        Assertions.assertArrayEquals(expected, solution1314.matrixBlockSum(mat, k));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[45,45,45],[45,45,45],[45,45,45]]");
        Assertions.assertArrayEquals(expected, solution1314.matrixBlockSum(mat, k));
    }
}
