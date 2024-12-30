import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1638Tests {
    private final Solution1638 solution1638 = new Solution1638();

    @Test
    public void example1() {
        String s = "aba";
        String t = "baba";
        int expected = 6;
        Assertions.assertEquals(expected, solution1638.countSubstrings(s, t));
    }

    @Test
    public void example2() {
        String s = "ab";
        String t = "bb";
        int expected = 3;
        Assertions.assertEquals(expected, solution1638.countSubstrings(s, t));
    }

    @Test
    public void example3() {
        String s = "a";
        String t = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution1638.countSubstrings(s, t));
    }

    @Test
    public void example4() {
        String s = "abe";
        String t = "bbc";
        int expected = 10;
        Assertions.assertEquals(expected, solution1638.countSubstrings(s, t));
    }
}