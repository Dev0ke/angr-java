import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution392Tests {
    private final Solution392 solution392 = new Solution392();

    @Test
    public void example1() {
        String s = "abc";
        String t = "ahbgdc";
        Assertions.assertTrue(solution392.isSubsequence(s, t));
    }

    @Test
    public void example2() {
        String s = "axc";
        String t = "ahbgdc";
        Assertions.assertFalse(solution392.isSubsequence(s, t));
    }
}
