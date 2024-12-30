import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1559Tests {
    private final Solution1559 solution1559 = new Solution1559();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
                """);
        Assertions.assertTrue(solution1559.containsCycle(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
                """);
        Assertions.assertTrue(solution1559.containsCycle(grid));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [["a","b","b"],["b","z","b"],["b","b","a"]]
                """);
        Assertions.assertFalse(solution1559.containsCycle(grid));
    }
}