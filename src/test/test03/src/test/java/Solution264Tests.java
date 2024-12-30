import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution264Tests {
    private final Solution264 solution264 = new Solution264();

    @Test
    public void example1() {
        int n = 10;
        int expected = 12;
        Assertions.assertEquals(expected, solution264.nthUglyNumber(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution264.nthUglyNumber(n));
    }
}
