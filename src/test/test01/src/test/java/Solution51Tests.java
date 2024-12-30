import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution51Tests {
    private final Solution51 solution51 = new Solution51();

    @Test
    public void example1() {
        int n = 4;
        List<List<String>> actual = solution51.solveNQueens(n);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
                """);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 1;
        List<List<String>> actual = solution51.solveNQueens(n);
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["Q"]]
                """);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
