import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1969Tests {
    private final Solution1969 solution1969 = new Solution1969();

    @Test
    public void example1() {
        int p = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1969.minNonZeroProduct(p));
    }

    @Test
    public void example2() {
        int p = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1969.minNonZeroProduct(p));
    }

    @Test
    public void example3() {
        int p = 3;
        int expected = 1512;
        Assertions.assertEquals(expected, solution1969.minNonZeroProduct(p));
    }
}
