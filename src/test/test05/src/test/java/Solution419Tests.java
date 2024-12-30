import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution419Tests {
    private final Solution419 solution419 = new Solution419();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
                """);
        int expected = 2;
        Assertions.assertEquals(expected, solution419.countBattleships(board));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["."]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution419.countBattleships(board));
    }
}
