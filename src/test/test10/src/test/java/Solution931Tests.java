import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution931Tests {
    private final Solution931 solution931 = new Solution931();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[2,1,3],[6,5,4],[7,8,9]]");
        int expected = 13;
        Assertions.assertEquals(expected, solution931.minFallingPathSum(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[-19,57],[-40,-5]]");
        int expected = -59;
        Assertions.assertEquals(expected, solution931.minFallingPathSum(matrix));
    }
}
