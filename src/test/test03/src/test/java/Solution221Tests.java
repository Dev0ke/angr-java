import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution221Tests {
    private final Solution221 solution221 = new Solution221();

    @Test
    public void example1() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
                """);
        int expected = 4;
        Assertions.assertEquals(expected, solution221.maximalSquare(matrix));
    }

    @Test
    public void example2() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["0","1"],["1","0"]]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution221.maximalSquare(matrix));
    }

    @Test
    public void example3() {
        char[][] matrix = UtUtils.stringToChars2("""
                [["0"]]
                """);
        int expected = 0;
        Assertions.assertEquals(expected, solution221.maximalSquare(matrix));
    }
}
