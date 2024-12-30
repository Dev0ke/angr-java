import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1222Tests {
    private final Solution1222 solution1222 = new Solution1222();

    @Test
    public void example1() {
        int[][] queens = UtUtils.stringToInts2("[[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]]");
        int[] king = {0, 0};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,0],[3,3]]");
        List<List<Integer>> actual = solution1222.queensAttacktheKing(queens, king);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[][] queens = UtUtils.stringToInts2("[[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]]");
        int[] king = {3, 3};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,2],[3,4],[4,4]]");
        List<List<Integer>> actual = solution1222.queensAttacktheKing(queens, king);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[][] queens = UtUtils.stringToInts2("[[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]]");
        int[] king = {3, 4};
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]");
        List<List<Integer>> actual = solution1222.queensAttacktheKing(queens, king);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}