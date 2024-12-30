import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution344Tests {
    private final Solution344 solution344 = new Solution344();

    @Test
    public void example1() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution344.reverseString(s);
        char[] expected = {'o', 'l', 'l', 'e', 'h'};
        Assertions.assertArrayEquals(expected, s);
    }

    @Test
    public void example2() {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution344.reverseString(s);
        char[] expected = {'h', 'a', 'n', 'n', 'a', 'H'};
        Assertions.assertArrayEquals(expected, s);
    }
}
