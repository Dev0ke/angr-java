import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution483Tests {
    private final Solution483 solution483 = new Solution483();

    @Test
    public void example1() {
        String n = "13";
        String expected = "3";
        Assertions.assertEquals(expected, solution483.smallestGoodBase(n));
    }

    @Test
    public void example2() {
        String n = "4681";
        String expected = "8";
        Assertions.assertEquals(expected, solution483.smallestGoodBase(n));
    }

    @Test
    public void example3() {
        String n = "1000000000000000000";
        String expected = "999999999999999999";
        Assertions.assertEquals(expected, solution483.smallestGoodBase(n));
    }
}
