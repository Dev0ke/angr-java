import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution459Tests {
    private final Solution459 solution459 = new Solution459();

    @Test
    public void example1() {
        String s = "abab";
        Assertions.assertTrue(solution459.repeatedSubstringPattern(s));
        Assertions.assertTrue(solution459.repeatedSubstringPattern2(s));
    }

    @Test
    public void example2() {
        String s = "aba";
        Assertions.assertFalse(solution459.repeatedSubstringPattern(s));
        Assertions.assertFalse(solution459.repeatedSubstringPattern2(s));
    }

    @Test
    public void example3() {
        String s = "abcabcabcabc";
        Assertions.assertTrue(solution459.repeatedSubstringPattern(s));
        Assertions.assertTrue(solution459.repeatedSubstringPattern2(s));
    }
}
