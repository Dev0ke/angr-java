import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution54Tests {
    private final Solution54 solution54 = new Solution54();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        List<Integer> expected = List.of(1, 2, 3, 6, 9, 8, 7, 4, 5);
        Assertions.assertEquals(expected, solution54.spiralOrder(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");
        List<Integer> expected = List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        Assertions.assertEquals(expected, solution54.spiralOrder(matrix));
    }
}
