import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1595Tests {
    private final Solution1595 solution1595 = new Solution1595();

    @Test
    public void example1() {
        List<List<Integer>> cost = UtUtils.stringToIntegerList2("[[15, 96], [36, 2]]");
        int expected = 17;
        Assertions.assertEquals(expected, solution1595.connectTwoGroups(cost));
    }

    @Test
    public void example2() {
        List<List<Integer>> cost = UtUtils.stringToIntegerList2("[[1, 3, 5], [4, 1, 1], [1, 5, 3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1595.connectTwoGroups(cost));
    }

    @Test
    public void example3() {
        List<List<Integer>> cost = UtUtils.stringToIntegerList2("[[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution1595.connectTwoGroups(cost));
    }
}