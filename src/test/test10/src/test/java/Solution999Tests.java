import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution999Tests {
    private final Solution999 solution999 = new Solution999();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution999.numRookCaptures(board));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution999.numRookCaptures(board));
    }

    @Test
    public void example3() {
        char[][] board = UtUtils.stringToChars2("""
                [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution999.numRookCaptures(board));
    }
}