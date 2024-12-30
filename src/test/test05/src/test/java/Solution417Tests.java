import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution417Tests {
    private final Solution417 solution417 = new Solution417();

    @Test
    public void example1() {
        int[][] heights = UtUtils.stringToInts2("[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]");
        List<List<Integer>> actual = solution417.pacificAtlantic(heights);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[][] heights = UtUtils.stringToInts2("[[2,1],[1,2]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,0],[0,1],[1,0],[1,1]]");
        List<List<Integer>> actual = solution417.pacificAtlantic(heights);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
