import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1738Tests {
    private final Solution1738 solution1738 = new Solution1738();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[5,2],[1,6]]");
        int k = 1;
        int expected = 7;
        Assertions.assertEquals(expected, solution1738.kthLargestValue(matrix, k));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[5,2],[1,6]]");
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution1738.kthLargestValue(matrix, k));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[5,2],[1,6]]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution1738.kthLargestValue(matrix, k));
    }

    @Test
    public void example4() {
        int[][] matrix = UtUtils.stringToInts2("[[5,2],[1,6]]");
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution1738.kthLargestValue(matrix, k));
    }
}
