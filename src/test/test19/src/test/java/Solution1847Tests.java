import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1847Tests {
    private final Solution1847 solution1847 = new Solution1847();

    @Test
    public void example1() {
        int[][] rooms = UtUtils.stringToInts2("[[2,2],[1,2],[3,2]]");
        int[][] queries = UtUtils.stringToInts2("[[3,1],[3,3],[5,2]]");
        int[] expected = {3, -1, 3};
        Assertions.assertArrayEquals(expected, solution1847.closestRoom(rooms, queries));
    }

    @Test
    public void example2() {
        int[][] rooms = UtUtils.stringToInts2("[[1,4],[2,3],[3,5],[4,1],[5,2]]");
        int[][] queries = UtUtils.stringToInts2("[[2,3],[2,4],[2,5]]");
        int[] expected = {2, 1, 3};
        Assertions.assertArrayEquals(expected, solution1847.closestRoom(rooms, queries));
    }
}