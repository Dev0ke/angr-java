import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1380Tests {
    private final Solution1380 solution1380 = new Solution1380();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[3,7,8],[9,11,13],[15,16,17]]");
        List<Integer> expected = Arrays.asList(15);
        Assertions.assertEquals(expected, solution1380.luckyNumbers(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]");
        List<Integer> expected = Arrays.asList(12);
        Assertions.assertEquals(expected, solution1380.luckyNumbers(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[7,8],[1,2]]");
        List<Integer> expected = Arrays.asList(7);
        Assertions.assertEquals(expected, solution1380.luckyNumbers(matrix));
    }
}
