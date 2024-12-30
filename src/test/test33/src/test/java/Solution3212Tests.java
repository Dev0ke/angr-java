import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3212Tests {
    private final Solution3212 solution3212 = new Solution3212();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["X","Y","."],["Y",".","."]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution3212.numberOfSubmatrices(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["X","X"],["X","Y"]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution3212.numberOfSubmatrices(grid));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [[".","."],[".","."]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution3212.numberOfSubmatrices(grid));
    }
}