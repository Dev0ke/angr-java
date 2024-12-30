import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution52Tests {
    private final Solution52 solution52 = new Solution52();

    @Test
    public void example1() {
        int n = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution52.totalNQueens(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution52.totalNQueens(n));
    }
}
