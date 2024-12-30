import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution279Tests {
    private final Solution279 solution279 = new Solution279();

    @Test
    public void example1() {
        int n = 12;
        int expected = 3;
        Assertions.assertEquals(expected, solution279.numSquares(n));
    }

    @Test
    public void example2() {
        int n = 13;
        int expected = 2;
        Assertions.assertEquals(expected, solution279.numSquares(n));
    }
}
