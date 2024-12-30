import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2904Tests {
    private final Solution2904 solution2904 = new Solution2904();

    @Test
    public void example1() {
        String s = "100011001";
        int k = 3;
        String expected = "11001";
        Assertions.assertEquals(expected, solution2904.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void example2() {
        String s = "1011";
        int k = 2;
        String expected = "11";
        Assertions.assertEquals(expected, solution2904.shortestBeautifulSubstring(s, k));
    }

    @Test
    public void example3() {
        String s = "000";
        int k = 1;
        String expected = "";
        Assertions.assertEquals(expected, solution2904.shortestBeautifulSubstring(s, k));
    }
}