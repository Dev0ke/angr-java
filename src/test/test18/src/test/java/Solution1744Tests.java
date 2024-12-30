import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1744Tests {
    private final Solution1744 solution1744 = new Solution1744();

    @Test
    public void example1() {
        int[] candiesCount = {7, 4, 5, 3, 8};
        int[][] queries = UtUtils.stringToInts2("[[0,2,2],[4,2,4],[2,13,1000000000]]");
        boolean[] expected = {true, false, true};
        Assertions.assertArrayEquals(expected, solution1744.canEat(candiesCount, queries));
    }

    @Test
    public void example2() {
        int[] candiesCount = {5, 2, 6, 4, 1};
        int[][] queries = UtUtils.stringToInts2("[[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]");
        boolean[] expected = {false, true, true, false, false};
        Assertions.assertArrayEquals(expected, solution1744.canEat(candiesCount, queries));
    }
}