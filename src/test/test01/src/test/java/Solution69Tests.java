import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution69Tests {
    private final Solution69 solution69 = new Solution69();

    @Test
    public void example1() {
        int x = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution69.mySqrt(x));
    }

    @Test
    public void example2() {
        int x = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solution69.mySqrt(x));
    }
}
