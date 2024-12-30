import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1743Tests {
    private final Solution1743 solution1743 = new Solution1743();

    @Test
    public void example1() {
        int[][] adjacentPairs = UtUtils.stringToInts2("[[2,1],[3,4],[3,2]]");
        int[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solution1743.restoreArray(adjacentPairs));
    }

    @Test
    public void example2() {
        int[][] adjacentPairs = UtUtils.stringToInts2("[[4,-2],[1,4],[-3,1]]");
        int[] expected = {-2, 4, 1, -3};
        Assertions.assertArrayEquals(expected, solution1743.restoreArray(adjacentPairs));
    }

    @Test
    public void example3() {
        int[][] adjacentPairs = UtUtils.stringToInts2("[[100000,-100000]]");
        int[] expected = {100000, -100000};
        Assertions.assertArrayEquals(expected, solution1743.restoreArray(adjacentPairs));
    }
}