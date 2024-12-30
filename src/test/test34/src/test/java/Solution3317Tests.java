import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3317Tests {
    private final Solution3317 solution3317 = new Solution3317();

    @Test
    public void example1() {
        int n = 1;
        int x = 2;
        int y = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution3317.numberOfWays(n, x, y));
    }

    @Test
    public void example2() {
        int n = 5;
        int x = 2;
        int y = 1;
        int expected = 32;
        Assertions.assertEquals(expected, solution3317.numberOfWays(n, x, y));
    }

    @Test
    public void example3() {
        int n = 3;
        int x = 3;
        int y = 4;
        int expected = 684;
        Assertions.assertEquals(expected, solution3317.numberOfWays(n, x, y));
    }
}