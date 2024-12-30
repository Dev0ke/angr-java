import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2697Tests {
    private final Solution2697 solution2697 = new Solution2697();

    @Test
    public void example1() {
        String s = "egcfe";
        String expected = "efcfe";
        Assertions.assertEquals(expected, solution2697.makeSmallestPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "abba";
        Assertions.assertEquals(expected, solution2697.makeSmallestPalindrome(s));
    }

    @Test
    public void example3() {
        String s = "seven";
        String expected = "neven";
        Assertions.assertEquals(expected, solution2697.makeSmallestPalindrome(s));
    }
}