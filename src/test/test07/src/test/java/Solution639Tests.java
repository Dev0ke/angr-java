import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution639Tests {
    private final Solution639 solution639 = new Solution639();

    @Test
    public void example1() {
        String s = "*";
        int expected = 9;
        Assertions.assertEquals(expected, solution639.numDecodings(s));
    }

    @Test
    public void example2() {
        String s = "1*";
        int expected = 18;
        Assertions.assertEquals(expected, solution639.numDecodings(s));
    }

    @Test
    public void example3() {
        String s = "2*";
        int expected = 15;
        Assertions.assertEquals(expected, solution639.numDecodings(s));
    }
}