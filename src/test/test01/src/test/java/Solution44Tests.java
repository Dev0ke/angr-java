import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution44Tests {
    private final Solution44 solution44 = new Solution44();

    @Test
    public void example1() {
        String s = "aa";
        String p = "a";
        Assertions.assertFalse(solution44.isMatch(s, p));
    }

    @Test
    public void example2() {
        String s = "aa";
        String p = "*";
        Assertions.assertTrue(solution44.isMatch(s, p));
    }

    @Test
    public void example3() {
        String s = "cb";
        String p = "?a";
        Assertions.assertFalse(solution44.isMatch(s, p));
    }

    @Test
    public void example4() {
        String s = "adceb";
        String p = "a*b";
        Assertions.assertTrue(solution44.isMatch(s, p));
    }

    @Test
    public void example5() {
        String s = "acdcb";
        String p = "a*c?b";
        Assertions.assertFalse(solution44.isMatch(s, p));
    }
}
