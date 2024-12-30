import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2018Tests {
    private final Solution2018 solution2018 = new Solution2018();

    @Test
    public void example1() {
        char[][] board = UtUtils.stringToChars2("""
                [["#", " ", "#"], [" ", " ", "#"], ["#", "c", " "]]
                """);
        String word = "abc";
        Assertions.assertTrue(solution2018.placeWordInCrossword(board, word));
    }

    @Test
    public void example2() {
        char[][] board = UtUtils.stringToChars2("""
                [[" ", "#", "a"], [" ", "#", "c"], [" ", "#", "a"]]
                """);
        String word = "ac";
        Assertions.assertFalse(solution2018.placeWordInCrossword(board, word));
    }

    @Test
    public void example3() {
        char[][] board = UtUtils.stringToChars2("""
                [["#", " ", "#"], [" ", " ", "#"], ["#", " ", "c"]]
                """);
        String word = "ca";
        Assertions.assertTrue(solution2018.placeWordInCrossword(board, word));
    }
}
