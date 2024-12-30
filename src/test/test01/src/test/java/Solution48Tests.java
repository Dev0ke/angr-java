import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution48Tests {
    private final Solution48 solution48 = new Solution48();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[][] output = UtUtils.stringToInts2("[[7,4,1],[8,5,2],[9,6,3]]");
        solution48.rotate(matrix);
        Assertions.assertArrayEquals(matrix, output);
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        int[][] output = UtUtils.stringToInts2("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]");
        solution48.rotate(matrix);
        Assertions.assertArrayEquals(matrix, output);
    }

    @Test
    public void example3() {
        int[][] matrix = {{1}};
        int[][] output = {{1}};
        solution48.rotate(matrix);
        Assertions.assertArrayEquals(matrix, output);
    }

    @Test
    public void example4() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] output = {{3, 1}, {4, 2}};
        solution48.rotate(matrix);
        Assertions.assertArrayEquals(matrix, output);
    }
}
