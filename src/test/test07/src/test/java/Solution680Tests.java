import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution680Tests {
    private final Solution680 solution680 = new Solution680();

    @Test
    public void example1() {
        String s = "aba";
        Assertions.assertTrue(solution680.validPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "abca";
        Assertions.assertTrue(solution680.validPalindrome(s));
    }

    @Test
    public void example3() {
        String s = "abc";
        Assertions.assertFalse(solution680.validPalindrome(s));
    }
}
