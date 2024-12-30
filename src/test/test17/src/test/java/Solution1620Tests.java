import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1620Tests {
    private final Solution1620 solution1620 = new Solution1620();

    @Test
    public void example1() {
        int[][] towers = UtUtils.stringToInts2("[[1,2,5],[2,1,7],[3,1,9]]");
        int radius = 2;
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution1620.bestCoordinate(towers, radius));
    }

    @Test
    public void example2() {
        int[][] towers = UtUtils.stringToInts2("[[23,11,21]]");
        int radius = 9;
        int[] expected = {23, 11};
        Assertions.assertArrayEquals(expected, solution1620.bestCoordinate(towers, radius));
    }

    @Test
    public void example3() {
        int[][] towers = UtUtils.stringToInts2("[[1,2,13],[2,1,7],[0,1,9]]");
        int radius = 2;
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution1620.bestCoordinate(towers, radius));
    }
}
