import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3083Tests {
    private final Solution3083 solution3083 = new Solution3083();

    @Test
    public void example1() {
        String s = "leetcode";
        Assertions.assertTrue(solution3083.isSubstringPresent(s));
    }

    @Test
    public void example2() {
        String s = "abcba";
        Assertions.assertTrue(solution3083.isSubstringPresent(s));
    }

    @Test
    public void example3() {
        String s = "abcd";
        Assertions.assertFalse(solution3083.isSubstringPresent(s));
    }
}