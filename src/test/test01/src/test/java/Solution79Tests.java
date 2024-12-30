import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution79Tests {
    private final Solution79 solution79 = new Solution79();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
                """);
        String word = "ABCCED";
        Assertions.assertTrue(solution79.exist(board, word));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
                """);
        String word = "SEE";
        Assertions.assertTrue(solution79.exist(board, word));
    }

    @Test
    public void example3() {
        char[][] board = UtUtils.stringToChars2("""
                [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
                """);
        String word = "ABCB";
        Assertions.assertFalse(solution79.exist(board, word));
    }
}
