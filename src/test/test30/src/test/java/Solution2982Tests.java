import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2982Tests {
    private final Solution2982 solution2982 = new Solution2982();

    @Test
    public void example1() {
        String s = "aaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution2982.maximumLength(s));
    }

    @Test
    public void example2() {
        String s = "abcdef";
        int expected = -1;
        Assertions.assertEquals(expected, solution2982.maximumLength(s));
    }

    @Test
    public void example3() {
        String s = "abcaba";
        int expected = 1;
        Assertions.assertEquals(expected, solution2982.maximumLength(s));
    }
}