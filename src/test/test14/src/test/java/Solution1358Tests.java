import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1358Tests {
    private final Solution1358 solution1358 = new Solution1358();

    @Test
    public void example1() {
        String s = "abcabc";
        int expected = 10;
        Assertions.assertEquals(expected, solution1358.numberOfSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "aaacb";
        int expected = 3;
        Assertions.assertEquals(expected, solution1358.numberOfSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "abc";
        int expected = 1;
        Assertions.assertEquals(expected, solution1358.numberOfSubstrings(s));
    }
}
