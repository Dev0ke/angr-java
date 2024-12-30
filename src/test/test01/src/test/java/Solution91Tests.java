import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution91Tests {
    private final Solution91 solution91 = new Solution91();

    @Test
    public void example1() {
        String s = "12";
        int expected = 2;
        Assertions.assertEquals(expected, solution91.numDecodings(s));
    }

    @Test
    public void example2() {
        String s = "226";
        int expected = 3;
        Assertions.assertEquals(expected, solution91.numDecodings(s));
    }

    @Test
    public void example3() {
        String s = "0";
        int expected = 0;
        Assertions.assertEquals(expected, solution91.numDecodings(s));
    }

    @Test
    public void example4() {
        String s = "06";
        int expected = 0;
        Assertions.assertEquals(expected, solution91.numDecodings(s));
    }
}
