import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1828Tests {
    private final Solution1828 solution1828 = new Solution1828();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,3],[3,3],[5,3],[2,2]]");
        int[][] queries = UtUtils.stringToInts2("[[2,3,1],[4,3,1],[1,1,2]]");
        int[] expected = {3, 2, 2};
        Assertions.assertArrayEquals(expected, solution1828.countPoints(points, queries));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,2],[3,3],[4,4],[5,5]]");
        int[][] queries = UtUtils.stringToInts2("[[1,2,2],[2,2,2],[4,3,2],[4,3,3]]");
        int[] expected = {2, 3, 2, 4};
        Assertions.assertArrayEquals(expected, solution1828.countPoints(points, queries));
    }
}