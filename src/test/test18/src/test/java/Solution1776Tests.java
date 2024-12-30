import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1776Tests {
    private final Solution1776 solution1776 = new Solution1776();

    @Test
    public void example1() {
        int[][] cars = UtUtils.stringToInts2("[[1,2],[2,1],[4,3],[7,2]]");
        double[] expected = {1.00000, -1.00000, 3.00000, -1.00000};
        Assertions.assertArrayEquals(expected, solution1776.getCollisionTimes(cars));
    }

    @Test
    public void example2() {
        int[][] cars = UtUtils.stringToInts2("[[3,4],[5,4],[6,3],[9,1]]");
        double[] expected = {2.00000, 1.00000, 1.50000, -1.00000};
        Assertions.assertArrayEquals(expected, solution1776.getCollisionTimes(cars));
    }
}