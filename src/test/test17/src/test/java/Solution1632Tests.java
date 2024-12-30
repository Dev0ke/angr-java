import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1632Tests {
    private final Solution1632.V1 solution1632_v1 = new Solution1632.V1();
    private final Solution1632.V2 solution1632_v2 = new Solution1632.V2();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[][] expected = UtUtils.stringToInts2("[[1,2],[2,3]]");
        Assertions.assertArrayEquals(expected, solution1632_v1.matrixRankTransform(matrix));
        Assertions.assertArrayEquals(expected, solution1632_v2.matrixRankTransform(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[7,7],[7,7]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1],[1,1]]");
        Assertions.assertArrayEquals(expected, solution1632_v1.matrixRankTransform(matrix));
        Assertions.assertArrayEquals(expected, solution1632_v2.matrixRankTransform(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]");
        int[][] expected = UtUtils.stringToInts2("[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]");
        Assertions.assertArrayEquals(expected, solution1632_v1.matrixRankTransform(matrix));
        Assertions.assertArrayEquals(expected, solution1632_v2.matrixRankTransform(matrix));
    }
}