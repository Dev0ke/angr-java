import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution794Tests {
    private final Solution794 solution794 = new Solution794();

    @Test
    public void example1() {
        String[] board = {"O  ", "   ", "   "};
        Assertions.assertFalse(solution794.validTicTacToe(board));
    }

    @Test
    public void example2() {
        String[] board = {"XOX", " X ", "   "};
        Assertions.assertFalse(solution794.validTicTacToe(board));
    }

    @Test
    public void example3() {
        String[] board = {"XXX", "   ", "OOO"};
        Assertions.assertFalse(solution794.validTicTacToe(board));
    }

    @Test
    public void example4() {
        String[] board = {"XOX", "O O", "XOX"};
        Assertions.assertTrue(solution794.validTicTacToe(board));
    }
}
