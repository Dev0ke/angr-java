import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3070Tests {
    private final Solution3070 solution3070 = new Solution3070();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[7,6,3],[6,6,1]]");
        int k = 18;
        int expected = 4;
        Assertions.assertEquals(expected, solution3070.countSubmatrices(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[7,2,9],[1,5,0],[2,6,6]]");
        int k = 20;
        int expected = 6;
        Assertions.assertEquals(expected, solution3070.countSubmatrices(grid, k));
    }
}