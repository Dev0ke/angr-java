import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1680Tests {
    private final Solution1680 solution1680 = new Solution1680();

    @Test
    public void example1() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1680.concatenatedBinary(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 27;
        Assertions.assertEquals(expected, solution1680.concatenatedBinary(n));
    }

    @Test
    public void example3() {
        int n = 12;
        int expected = 505379714;
        Assertions.assertEquals(expected, solution1680.concatenatedBinary(n));
    }
}