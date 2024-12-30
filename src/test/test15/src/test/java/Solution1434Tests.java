import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1434Tests {
    private final Solution1434 solution1434 = new Solution1434();

    @Test
    public void example1() {
        List<List<Integer>> hats = UtUtils.stringToIntegerList2("[[3,4],[4,5],[5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1434.numberWays(hats));
    }

    @Test
    public void example2() {
        List<List<Integer>> hats = UtUtils.stringToIntegerList2("[[3,5,1],[3,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1434.numberWays(hats));
    }

    @Test
    public void example3() {
        List<List<Integer>> hats = UtUtils.stringToIntegerList2("[[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution1434.numberWays(hats));
    }

    @Test
    public void example4() {
        List<List<Integer>> hats = UtUtils.stringToIntegerList2("[[1,2,3],[2,3,5,6],[1,3,7,9],[1,8,9],[2,5,7]]");
        int expected = 111;
        Assertions.assertEquals(expected, solution1434.numberWays(hats));
    }
}
