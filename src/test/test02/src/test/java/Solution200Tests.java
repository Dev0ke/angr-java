import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution200Tests {
    private final Solution200 solution200 = new Solution200();

    @Test
    public void example1() {
        char[][] grid = UtUtils.stringToChars2("""
                [
                  ["1","1","1","1","0"],
                  ["1","1","0","1","0"],
                  ["1","1","0","0","0"],
                  ["0","0","0","0","0"]
                ]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution200.numIslands(grid));
    }

    @Test
    public void example2() {
        char[][] grid = UtUtils.stringToChars2("""
                [
                  ["1","1","0","0","0"],
                  ["1","1","0","0","0"],
                  ["0","0","1","0","0"],
                  ["0","0","0","1","1"]
                ]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution200.numIslands(grid));
    }
}


