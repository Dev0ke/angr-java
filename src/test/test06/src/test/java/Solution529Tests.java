import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution529Tests {
    private final Solution529 solution529 = new Solution529();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]]
                """);
        int[] click = {3, 0};
        char[][] expected = UtUtils.stringToChars2("""
                [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
                """);
        Assertions.assertArrayEquals(expected, solution529.updateBoard(board, click));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
                """);
        int[] click = {1, 2};
        char[][] expected = UtUtils.stringToChars2("""
                [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
                """);
        Assertions.assertArrayEquals(expected, solution529.updateBoard(board, click));
    }
}
