import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2565Tests {
    private final Solution2565 solution2565 = new Solution2565();

    @Test
    public void example1() {
        String s = "abacaba";
        String t = "bzaa";
        int expected = 1;
        Assertions.assertEquals(expected, solution2565.minimumScore(s, t));
    }

    @Test
    public void example2() {
        String s = "cde";
        String t = "xyz";
        int expected = 3;
        Assertions.assertEquals(expected, solution2565.minimumScore(s, t));
    }
}