import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1958Tests {
    private final Solution1958 solution1958 = new Solution1958();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W","B","B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."]]
                """);
        int rMove = 4;
        int cMove = 3;
        char color = 'B';
        Assertions.assertTrue(solution1958.checkMove(board, rMove, cMove, color));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".","."],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",".",".","W","."],[".",".",".",".",".",".",".","B"]]
                """);
        int rMove = 4;
        int cMove = 4;
        char color = 'W';
        Assertions.assertFalse(solution1958.checkMove(board, rMove, cMove, color));
    }
}
