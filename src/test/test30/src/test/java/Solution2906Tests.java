import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2906Tests {
    private final Solution2906 solution2906 = new Solution2906();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[][] expected = UtUtils.stringToInts2("[[24,12],[8,6]]");
        Assertions.assertArrayEquals(expected, solution2906.constructProductMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[12345],[2],[1]]");
        int[][] expected = UtUtils.stringToInts2("[[2],[0],[0]]");
        Assertions.assertArrayEquals(expected, solution2906.constructProductMatrix(grid));
    }
}