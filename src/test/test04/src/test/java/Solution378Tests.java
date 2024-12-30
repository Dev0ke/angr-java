import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution378Tests {
    private final Solution378 solution378 = new Solution378();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,5,9],[10,11,13],[12,13,15]]");
        int k = 8;
        int expected = 13;
        Assertions.assertEquals(expected, solution378.kthSmallest(matrix, k));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[-5]]");
        int k = 1;
        int expected = -5;
        Assertions.assertEquals(expected, solution378.kthSmallest(matrix, k));
    }
}
