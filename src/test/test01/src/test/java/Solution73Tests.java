import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution73Tests {
    private final Solution73 solution73 = new Solution73();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,0,1],[0,0,0],[1,0,1]]");
        solution73.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0,0],[0,4,5,0],[0,3,1,0]]");
        solution73.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
