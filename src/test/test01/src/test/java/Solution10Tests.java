import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution10Tests {
    private final Solution10 solution10 = new Solution10();

    @Test
    public void example1() {
        String s = "aa";
        String p = "a";
        Assertions.assertFalse(solution10.isMatch(s, p));
    }

    @Test
    public void example2() {
        String s = "aa";
        String p = "a*";
        Assertions.assertTrue(solution10.isMatch(s, p));
    }

    @Test
    public void example3() {
        String s = "ab";
        String p = ".*";
        Assertions.assertTrue(solution10.isMatch(s, p));
    }

    @Test
    public void example4() {
        String s = "aab";
        String p = "c*a*b";
        Assertions.assertTrue(solution10.isMatch(s, p));
    }

    @Test
    public void example5() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        Assertions.assertFalse(solution10.isMatch(s, p));
    }
}
