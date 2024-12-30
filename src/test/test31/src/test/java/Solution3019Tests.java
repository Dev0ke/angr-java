import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3019Tests {
    private final Solution3019 solution3019 = new Solution3019();

    @Test
    public void example1() {
        String s = "aAbBcC";
        int expected = 2;
        Assertions.assertEquals(expected, solution3019.countKeyChanges(s));
    }

    @Test
    public void example2() {
        String s = "AaAaAaaA";
        int expected = 0;
        Assertions.assertEquals(expected, solution3019.countKeyChanges(s));
    }
}