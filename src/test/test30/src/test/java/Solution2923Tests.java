import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2923Tests {
    private final Solution2923 solution2923 = new Solution2923();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2923.findChampion(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,1],[1,0,1],[0,0,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2923.findChampion(grid));
    }
}