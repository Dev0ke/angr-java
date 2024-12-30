import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2679Tests {
    private final Solution2679 solution2679 = new Solution2679();

    @Test
    public void example1() {
        int[][] nums = UtUtils.stringToInts2("[[7,2,1],[6,4,2],[6,5,3],[3,2,1]]");
        int expected = 15;
        Assertions.assertEquals(expected, solution2679.matrixSum(nums));
    }

    @Test
    public void example2() {
        int[][] nums = UtUtils.stringToInts2("[[1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2679.matrixSum(nums));
    }
}