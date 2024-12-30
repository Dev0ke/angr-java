import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1298Tests {
    private final Solution1298 solution1298 = new Solution1298();

    @Test
    public void example1() {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = UtUtils.stringToInts2("[[],[],[1],[]]");
        int[][] containedBoxes = UtUtils.stringToInts2("[[1,2],[3],[],[]]");
        int[] initialBoxes = {0};
        int expected = 16;
        Assertions.assertEquals(expected, solution1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    @Test
    public void example2() {
        int[] status = {1, 0, 0, 0, 0, 0};
        int[] candies = {1, 1, 1, 1, 1, 1};
        int[][] keys = UtUtils.stringToInts2("[[1,2,3,4,5],[],[],[],[],[]]");
        int[][] containedBoxes = UtUtils.stringToInts2("[[1,2,3,4,5],[],[],[],[],[]]");
        int[] initialBoxes = {0};
        int expected = 6;
        Assertions.assertEquals(expected, solution1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    @Test
    public void example3() {
        int[] status = {1, 1, 1};
        int[] candies = {100, 1, 100};
        int[][] keys = UtUtils.stringToInts2("[[],[0,2],[]]");
        int[][] containedBoxes = UtUtils.stringToInts2("[[],[],[]]");
        int[] initialBoxes = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    @Test
    public void example4() {
        int[] status = {1, 1, 1};
        int[] candies = {2, 3, 2};
        int[][] keys = UtUtils.stringToInts2("[[],[],[]]");
        int[][] containedBoxes = UtUtils.stringToInts2("[[],[],[]]");
        int[] initialBoxes = {2, 1, 0};
        int expected = 7;
        Assertions.assertEquals(expected, solution1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }

    @Test
    public void example5() {
        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = UtUtils.stringToInts2("[[],[],[1],[]]");
        int[][] containedBoxes = UtUtils.stringToInts2("[[1,2],[3],[],[]]");
        int[] initialBoxes = {0};
        int expected = 16;
        Assertions.assertEquals(expected, solution1298.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}