import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1263Tests {
    private final Solution1263 solution1263 = new Solution1263();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [["#","#","#","#","#","#"],
                ["#","T","#","#","#","#"],
                ["#",".",".","B",".","#"],
                ["#",".","#","#",".","#"],
                ["#",".",".",".","S","#"],
                ["#","#","#","#","#","#"]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution1263.minPushBox(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [["#","#","#","#","#","#"],
                ["#","T","#","#","#","#"],
                ["#",".",".","B",".","#"],
                ["#","#","#","#",".","#"],
                ["#",".",".",".","S","#"],
                ["#","#","#","#","#","#"]]
                """);
        int expected = -1;
        Assertions.assertEquals(expected, solution1263.minPushBox(grid));
    }

    @Test
    public void example3() {
        char[][] grid = UtUtils.stringToChars2("""
                [["#","#","#","#","#","#"],
                ["#","T",".",".","#","#"],
                ["#",".","#","B",".","#"],
                ["#",".",".",".",".","#"],
                ["#",".",".",".","S","#"],
                ["#","#","#","#","#","#"]]
                """);
        int expected = 5;
        Assertions.assertEquals(expected, solution1263.minPushBox(grid));
    }
}