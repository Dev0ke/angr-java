import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1253Tests {
    private final Solution1253 solution1253 = new Solution1253();

    @Test
    public void example1() {
        int upper = 2;
        int lower = 1;
        int[] colsum = {1, 1, 1};
//        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,1,0],[0,0,1]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1, 0, 1], [0, 1, 0]]");
        Assertions.assertEquals(expected, solution1253.reconstructMatrix(upper, lower, colsum));
    }

    @Test
    public void example2() {
        int upper = 2;
        int lower = 3;
        int[] colsum = {2, 2, 1, 1};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution1253.reconstructMatrix(upper, lower, colsum));
    }

    @Test
    public void example3() {
        int upper = 5;
        int lower = 5;
        int[] colsum = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};
//        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1, 0, 1, 0, 1, 0, 0, 1, 0, 1], [1, 1, 1, 0, 0, 0, 1, 1, 0, 0]]");
        Assertions.assertEquals(expected, solution1253.reconstructMatrix(upper, lower, colsum));
    }
}