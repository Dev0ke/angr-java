import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution214Tests {
    private final Solution214 solution214 = new Solution214();

    @Test
    public void example1() {
        String s = "aacecaaa";
        String expected = "aaacecaaa";
        Assertions.assertEquals(expected, solution214.shortestPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "dcbabcd";
        Assertions.assertEquals(expected, solution214.shortestPalindrome(s));
    }
}
