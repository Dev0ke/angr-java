import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution363Tests {
    private final Solution363 solution363 = new Solution363();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,0,1],[0,-2,3]]");
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution363.maxSumSubmatrix(matrix, k));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[2,2,-1]]");
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution363.maxSumSubmatrix(matrix, k));
    }
}
