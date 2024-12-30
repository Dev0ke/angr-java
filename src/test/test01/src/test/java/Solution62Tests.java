import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution62Tests {
    private final Solution62 solution62 = new Solution62();

    @Test
    public void example1() {
        int m = 3;
        int n = 7;
        int expected = 28;
        Assertions.assertEquals(expected, solution62.uniquePaths(m, n));
        Assertions.assertEquals(expected, solution62.uniquePaths2(m, n));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution62.uniquePaths(m, n));
        Assertions.assertEquals(expected, solution62.uniquePaths2(m, n));
    }

    @Test
    public void example3() {
        int m = 7;
        int n = 3;
        int expected = 28;
        Assertions.assertEquals(expected, solution62.uniquePaths(m, n));
        Assertions.assertEquals(expected, solution62.uniquePaths2(m, n));
    }

    @Test
    public void example4() {
        int m = 3;
        int n = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution62.uniquePaths(m, n));
        Assertions.assertEquals(expected, solution62.uniquePaths2(m, n));
    }
}
