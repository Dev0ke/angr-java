import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution172Tests {
    private final Solution172 solution172 = new Solution172();

    @Test
    public void example1() {
        int n = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution172.trailingZeroes(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution172.trailingZeroes(n));
    }

    @Test
    public void example3() {
        int n = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution172.trailingZeroes(n));
    }
}
