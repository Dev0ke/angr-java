import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution168Tests {
    private final Solution168 solution168 = new Solution168();

    @Test
    public void example1() {
        int columnNumber = 1;
        String expected = "A";
        Assertions.assertEquals(expected, solution168.convertToTitle(columnNumber));
    }

    @Test
    public void example2() {
        int columnNumber = 28;
        String expected = "AB";
        Assertions.assertEquals(expected, solution168.convertToTitle(columnNumber));
    }

    @Test
    public void example3() {
        int columnNumber = 701;
        String expected = "ZY";
        Assertions.assertEquals(expected, solution168.convertToTitle(columnNumber));
    }

    @Test
    public void example4() {
        int columnNumber = 2147483647;
        String expected = "FXSHRXW";
        Assertions.assertEquals(expected, solution168.convertToTitle(columnNumber));
    }
}
