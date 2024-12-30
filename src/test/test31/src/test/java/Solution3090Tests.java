import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3090Tests {
    private final Solution3090 solution3090 = new Solution3090();

    @Test
    public void example1() {
        String s = "bcbbbcba";
        int expected = 4;
        Assertions.assertEquals(expected, solution3090.maximumLengthSubstring(s));
    }

    @Test
    public void example2() {
        String s = "aaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution3090.maximumLengthSubstring(s));
    }
}