import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution861Tests {
    private final Solution861 solution861 = new Solution861();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]");
        int expected = 39;
        Assertions.assertEquals(expected, solution861.matrixScore(grid));
    }
}
