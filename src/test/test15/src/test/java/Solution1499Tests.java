import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1499Tests {
    private final Solution1499 solution1499 = new Solution1499();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,3],[2,0],[5,10],[6,-10]]");
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution1499.findMaxValueOfEquation(points, k));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[3,0],[9,2]]");
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1499.findMaxValueOfEquation(points, k));
    }
}