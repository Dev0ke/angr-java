import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3110Tests {
    private final Solution3110 solution3110 = new Solution3110();

    @Test
    public void example1() {
        String s = "hello";
        int expected = 13;
        Assertions.assertEquals(expected, solution3110.scoreOfString(s));
    }

    @Test
    public void example2() {
        String s = "zaz";
        int expected = 50;
        Assertions.assertEquals(expected, solution3110.scoreOfString(s));
    }
}