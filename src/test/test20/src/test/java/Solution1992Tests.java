import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1992Tests {
    private final Solution1992 solution1992 = new Solution1992();

    @Test
    public void example1() {
        int[][] land = UtUtils.stringToInts2("[[1,0,0],[0,1,1],[0,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0,0],[1,1,2,2]]");
        Assertions.assertArrayEquals(expected, solution1992.findFarmland(land));
    }

    @Test
    public void example2() {
        int[][] land = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,1,1]]");
        Assertions.assertArrayEquals(expected, solution1992.findFarmland(land));
    }

    @Test
    public void example3() {
        int[][] land = UtUtils.stringToInts2("[[0]]");
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution1992.findFarmland(land));
    }
}
