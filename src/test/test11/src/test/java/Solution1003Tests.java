import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1003Tests {
    private final Solution1003 solution1003 = new Solution1003();

    @Test
    public void example1() {
        String s = "aabcbc";
        Assertions.assertTrue(solution1003.isValid(s));
    }

    @Test
    public void example2() {
        String s = "abcabcababcc";
        Assertions.assertTrue(solution1003.isValid(s));
    }

    @Test
    public void example3() {
        String s = "abccba";
        Assertions.assertFalse(solution1003.isValid(s));
    }
}