import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1297Tests {
    private final Solution1297 solution1297 = new Solution1297();

    @Test
    public void example1() {
        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1297.maxFreq(s, maxLetters, minSize, maxSize));
    }

    @Test
    public void example2() {
        String s = "aaaa";
        int maxLetters = 1;
        int minSize = 3;
        int maxSize = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1297.maxFreq(s, maxLetters, minSize, maxSize));
    }

    @Test
    public void example3() {
        String s = "aabcabcab";
        int maxLetters = 2;
        int minSize = 2;
        int maxSize = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1297.maxFreq(s, maxLetters, minSize, maxSize));
    }

    @Test
    public void example4() {
        String s = "abcde";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1297.maxFreq(s, maxLetters, minSize, maxSize));
    }
}