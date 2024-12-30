import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1910Tests {
    private final Solution1910 solution1910 = new Solution1910();

    @Test
    public void example1() {
        String s = "daabcbaabcbc";
        String part = "abc";
        String expected = "dab";
        Assertions.assertEquals(expected, solution1910.removeOccurrences(s, part));
    }

    @Test
    public void example2() {
        String s = "axxxxyyyyb";
        String part = "xy";
        String expected = "ab";
        Assertions.assertEquals(expected, solution1910.removeOccurrences(s, part));
    }
}
