import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution299Tests {
    private final Solution299 solution299 = new Solution299();

    @Test
    public void example1() {
        String secret = "1807";
        String guess = "7810";
        String expected = "1A3B";
        Assertions.assertEquals(expected, solution299.getHint(secret, guess));
    }

    @Test
    public void example2() {
        String secret = "1123";
        String guess = "0111";
        String expected = "1A1B";
        Assertions.assertEquals(expected, solution299.getHint(secret, guess));
    }

    @Test
    public void example3() {
        String secret = "1";
        String guess = "0";
        String expected = "0A0B";
        Assertions.assertEquals(expected, solution299.getHint(secret, guess));
    }

    @Test
    public void example4() {
        String secret = "1";
        String guess = "1";
        String expected = "1A0B";
        Assertions.assertEquals(expected, solution299.getHint(secret, guess));
    }
}
