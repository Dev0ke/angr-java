import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2839Tests {
    private final Solution2839 solution2839 = new Solution2839();

    @Test
    public void example1() {
        String s1 = "abcd";
        String s2 = "cdab";
        Assertions.assertTrue(solution2839.canBeEqual(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abcd";
        String s2 = "dacb";
        Assertions.assertFalse(solution2839.canBeEqual(s1, s2));
    }
}