import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution240Tests {
    private final Solution240 solution240 = new Solution240();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        int target = 5;
        Assertions.assertTrue(solution240.searchMatrix(matrix, target));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        int target = 20;
        Assertions.assertFalse(solution240.searchMatrix(matrix, target));
    }
}
