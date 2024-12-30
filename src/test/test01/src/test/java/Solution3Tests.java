import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3Tests {
    private final Solution3 solution3 = new Solution3();

    @Test
    public void example1() {
        String s = "abcabcbb";
        int expected = 3;
        Assertions.assertEquals(expected, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void example2() {
        String s = "bbbbb";
        int expected = 1;
        Assertions.assertEquals(expected, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void example3() {
        String s = "pwwkew";
        int expected = 3;
        Assertions.assertEquals(expected, solution3.lengthOfLongestSubstring(s));
    }

    @Test
    public void example4() {
        String s = "";
        int expected = 0;
        Assertions.assertEquals(expected, solution3.lengthOfLongestSubstring(s));
    }
}
