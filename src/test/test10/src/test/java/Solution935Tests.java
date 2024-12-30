import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution935Tests {
    private final Solution935 solution935 = new Solution935();

    @Test
    public void example1() {
        int n = 1;
        int expected = 10;
        Assertions.assertEquals(expected, solution935.knightDialer(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solution935.knightDialer(n));
    }

    @Test
    public void example3() {
        int n = 3131;
        int expected = 136006598;
        Assertions.assertEquals(expected, solution935.knightDialer(n));
    }
}