import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution709Tests {
    private final Solution709 solution709 = new Solution709();

    @Test
    public void example1() {
        String s = "Hello";
        String expected = "hello";
        Assertions.assertEquals(expected, solution709.toLowerCase(s));
    }

    @Test
    public void example2() {
        String s = "here";
        String expected = "here";
        Assertions.assertEquals(expected, solution709.toLowerCase(s));
    }

    @Test
    public void example3() {
        String s = "LOVELY";
        String expected = "lovely";
        Assertions.assertEquals(expected, solution709.toLowerCase(s));
    }
}
