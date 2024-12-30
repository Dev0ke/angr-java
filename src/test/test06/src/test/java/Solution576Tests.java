import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution576Tests {
    private final Solution576 solution576 = new Solution576();

    @Test
    public void example1() {
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRow = 0;
        int startColumn = 0;
        int expected = 6;
        Assertions.assertEquals(expected, solution576.findPaths(m, n, maxMove, startRow, startColumn));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 3;
        int maxMove = 3;
        int startRow = 0;
        int startColumn = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution576.findPaths(m, n, maxMove, startRow, startColumn));
    }
}
