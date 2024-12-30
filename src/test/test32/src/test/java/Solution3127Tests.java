import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3127Tests {
    private final Solution3127 solution3127 = new Solution3127();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["B","W","B"],["B","W","W"],["B","W","B"]]
                """);
        Assertions.assertTrue(solution3127.canMakeSquare(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["B","W","B"],["W","B","W"],["B","W","B"]]
                """);
        Assertions.assertFalse(solution3127.canMakeSquare(grid));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [["B","W","B"],["B","W","W"],["B","W","W"]]
                """);
        Assertions.assertTrue(solution3127.canMakeSquare(grid));
    }
}