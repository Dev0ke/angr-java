import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3365Tests {
    private final Solution3365 solution3365 = new Solution3365();

    @Test
    public void example1() {
        String s = "abcd";
        String t = "cdab";
        int k = 2;
        Assertions.assertTrue(solution3365.isPossibleToRearrange(s, t, k));
    }

    @Test
    public void example2() {
        String s = "aabbcc";
        String t = "bbaacc";
        int k = 3;
        Assertions.assertTrue(solution3365.isPossibleToRearrange(s, t, k));
    }

    @Test
    public void example3() {
        String s = "aabbcc";
        String t = "bbaacc";
        int k = 2;
        Assertions.assertFalse(solution3365.isPossibleToRearrange(s, t, k));
    }
}