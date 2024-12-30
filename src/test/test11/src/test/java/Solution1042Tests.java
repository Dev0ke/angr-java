import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1042Tests {
    private final Solution1042 solution1042 = new Solution1042();

    @Test
    public void example1() {
        int n = 3;
        int[][] paths = UtUtils.stringToInts2("[[1,2],[2,3],[3,1]]");
        int[] expected = {1, 2, 3};
        Assertions.assertArrayEquals(expected, solution1042.gardenNoAdj(n, paths));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] paths = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[] expected = {1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, solution1042.gardenNoAdj(n, paths));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] paths = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]");
        int[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution1042.gardenNoAdj(n, paths));
    }
}