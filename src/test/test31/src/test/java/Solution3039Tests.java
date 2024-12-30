import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3039Tests {
    private final Solution3039 solution3039 = new Solution3039();

    @Test
    public void example1() {
        String s = "aabcbbca";
        String expected = "ba";
        Assertions.assertEquals(expected, solution3039.lastNonEmptyString(s));
    }

    @Test
    public void example2() {
        String s = "abcd";
        String expected = "abcd";
        Assertions.assertEquals(expected, solution3039.lastNonEmptyString(s));
    }
}