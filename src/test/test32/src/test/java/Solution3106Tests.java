import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3106Tests {
    private final Solution3106 solution3106 = new Solution3106();

    @Test
    public void example1() {
        String s = "zbbz";
        int k = 3;
        String expected = "aaaz";
        Assertions.assertEquals(expected, solution3106.getSmallestString(s, k));
    }

    @Test
    public void example2() {
        String s = "xaxcd";
        int k = 4;
        String expected = "aawcd";
        Assertions.assertEquals(expected, solution3106.getSmallestString(s, k));
    }

    @Test
    public void example3() {
        String s = "lol";
        int k = 0;
        String expected = "lol";
        Assertions.assertEquals(expected, solution3106.getSmallestString(s, k));
    }
}