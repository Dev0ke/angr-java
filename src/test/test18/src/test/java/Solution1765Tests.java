import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1765Tests {
    private final Solution1765 solution1765 = new Solution1765();

    @Test
    public void example1() {
        int[][] isWater = UtUtils.stringToInts2("[[0,1],[0,0]]");
        int[][] expected = UtUtils.stringToInts2("[[1,0],[2,1]]");
        Assertions.assertArrayEquals(expected, solution1765.highestPeak(isWater));
    }

    @Test
    public void example2() {
        int[][] isWater = UtUtils.stringToInts2("[[0,0,1],[1,0,0],[0,0,0]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,0],[0,1,1],[1,2,2]]");
        Assertions.assertArrayEquals(expected, solution1765.highestPeak(isWater));
    }
}
