import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1931Tests {
    private final Solution1931 solution1931 = new Solution1931();

    @Test
    public void example1() {
        int m = 1;
        int n = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution1931.colorTheGrid(m, n));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1931.colorTheGrid(m, n));
    }

    @Test
    public void example3() {
        int m = 5;
        int n = 5;
        int expected = 580986;
        Assertions.assertEquals(expected, solution1931.colorTheGrid(m, n));
    }
}
