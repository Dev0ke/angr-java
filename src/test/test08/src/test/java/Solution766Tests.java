import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution766Tests {
    private final Solution766 solution766 = new Solution766();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]");
        Assertions.assertTrue(solution766.isToeplitzMatrix(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2],[2,2]]");
        Assertions.assertFalse(solution766.isToeplitzMatrix(matrix));
    }
}