import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution394Tests {
    private final Solution394 solution394 = new Solution394();

    @Test
    public void example1() {
        String s = "3[a]2[bc]";
        String expected = "aaabcbc";
        Assertions.assertEquals(expected, solution394.decodeString(s));
    }

    @Test
    public void example2() {
        String s = "3[a2[c]]";
        String expected = "accaccacc";
        Assertions.assertEquals(expected, solution394.decodeString(s));
    }

    @Test
    public void example3() {
        String s = "2[abc]3[cd]ef";
        String expected = "abcabccdcdcdef";
        Assertions.assertEquals(expected, solution394.decodeString(s));
    }

    @Test
    public void example4() {
        String s = "abc3[cd]xyz";
        String expected = "abccdcdcdxyz";
        Assertions.assertEquals(expected, solution394.decodeString(s));
    }
}
