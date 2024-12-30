import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1957Tests {
    private final Solution1957 solution1957 = new Solution1957();

    @Test
    public void example1() {
        String s = "leeetcode";
        String expected = "leetcode";
        Assertions.assertEquals(expected, solution1957.makeFancyString(s));
    }

    @Test
    public void example2() {
        String s = "aaabaaaa";
        String expected = "aabaa";
        Assertions.assertEquals(expected, solution1957.makeFancyString(s));
    }

    @Test
    public void example3() {
        String s = "aab";
        String expected = "aab";
        Assertions.assertEquals(expected, solution1957.makeFancyString(s));
    }
}
