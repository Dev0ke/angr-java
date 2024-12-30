import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1310Tests {
    private final Solution1310 solution1310 = new Solution1310();

    @Test
    public void example1() {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,2],[0,3],[3,3]]");
        int[] expected = {2, 7, 14, 8};
        Assertions.assertArrayEquals(expected, solution1310.xorQueries(arr, queries));
    }

    @Test
    public void example2() {
        int[] arr = {4, 8, 2, 10};
        int[][] queries = UtUtils.stringToInts2("[[2,3],[1,3],[0,0],[0,3]]");
        int[] expected = {8, 0, 4, 4};
        Assertions.assertArrayEquals(expected, solution1310.xorQueries(arr, queries));
    }
}