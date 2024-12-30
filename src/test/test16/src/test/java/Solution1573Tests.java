import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1573Tests {
    private final Solution1573 solution1573 = new Solution1573();

    @Test
    public void example1() {
        String s = "10101";
        int expected = 4;
        Assertions.assertEquals(expected, solution1573.numWays(s));
    }

    @Test
    public void example2() {
        String s = "1001";
        int expected = 0;
        Assertions.assertEquals(expected, solution1573.numWays(s));
    }

    @Test
    public void example3() {
        String s = "0000";
        int expected = 3;
        Assertions.assertEquals(expected, solution1573.numWays(s));
    }

    @Test
    public void example4() {
        String s = "100100010100110";
        int expected = 12;
        Assertions.assertEquals(expected, solution1573.numWays(s));
    }
}