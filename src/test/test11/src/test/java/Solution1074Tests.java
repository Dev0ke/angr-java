import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1074Tests {
    private final Solution1074 solution1074 = new Solution1074();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1,0],[1,1,1],[0,1,0]]");
        int target = 0;
        int expected = 4;
        Assertions.assertEquals(expected, solution1074.numSubmatrixSumTarget(matrix, target));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,-1],[-1,1]]");
        int target = 0;
        int expected = 5;
        Assertions.assertEquals(expected, solution1074.numSubmatrixSumTarget(matrix, target));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[904]]");
        int target = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution1074.numSubmatrixSumTarget(matrix, target));
    }
}