import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1914Tests {
    private final Solution1914 solution1914 = new Solution1914();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[40,10],[30,20]]");
        int k = 1;
        int[][] expected = UtUtils.stringToInts2("[[10,20],[40,30]]");
        Assertions.assertArrayEquals(expected, solution1914.rotateGrid(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]");
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]");
        Assertions.assertArrayEquals(expected, solution1914.rotateGrid(grid, k));
    }
}
