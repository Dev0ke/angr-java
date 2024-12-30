import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution552Tests {
    private final Solution552 solution552 = new Solution552();

    @Test
    public void example1() {
        int n = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution552.checkRecord(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution552.checkRecord(n));
    }

    @Test
    public void example3() {
        int n = 10101;
        int expected = 183236316;
        Assertions.assertEquals(expected, solution552.checkRecord(n));
    }
}
