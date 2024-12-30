import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution36Tests {
    private final Solution36 solution36 = new Solution36();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["5","3",".",".","7",".",".",".","."]
                ,["6",".",".","1","9","5",".",".","."]
                ,[".","9","8",".",".",".",".","6","."]
                ,["8",".",".",".","6",".",".",".","3"]
                ,["4",".",".","8",".","3",".",".","1"]
                ,["7",".",".",".","2",".",".",".","6"]
                ,[".","6",".",".",".",".","2","8","."]
                ,[".",".",".","4","1","9",".",".","5"]
                ,[".",".",".",".","8",".",".","7","9"]]
                """);
        Assertions.assertTrue(solution36.isValidSudoku(board));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [["8","3",".",".","7",".",".",".","."]
                ,["6",".",".","1","9","5",".",".","."]
                ,[".","9","8",".",".",".",".","6","."]
                ,["8",".",".",".","6",".",".",".","3"]
                ,["4",".",".","8",".","3",".",".","1"]
                ,["7",".",".",".","2",".",".",".","6"]
                ,[".","6",".",".",".",".","2","8","."]
                ,[".",".",".","4","1","9",".",".","5"]
                ,[".",".",".",".","8",".",".","7","9"]]
                """);
        Assertions.assertFalse(solution36.isValidSudoku(board));
    }
}
