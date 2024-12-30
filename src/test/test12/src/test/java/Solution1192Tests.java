import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1192Tests {
    private final Solution1192 solution1192 = new Solution1192();

    @Test
    public void example1() {
        int n = 4;
        List<List<Integer>> connections = UtUtils.stringToIntegerList2("[[0,1],[1,2],[2,0],[1,3]]");
        // 解释：[[3,1]] 也是正确的。
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,3]]");
        List<List<Integer>> actual = solution1192.criticalConnections(n, connections);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 2;
        List<List<Integer>> connections = UtUtils.stringToIntegerList2("[[0,1]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1]]");
        List<List<Integer>> actual = solution1192.criticalConnections(n, connections);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
