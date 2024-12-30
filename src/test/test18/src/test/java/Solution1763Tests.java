import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1763Tests {
    private final Solution1763.V1 solution1763_v1 = new Solution1763.V1();
    private final Solution1763.V2 solution1763_v2 = new Solution1763.V2();
    private final Solution1763.V3 solution1763_v3 = new Solution1763.V3();

    @Test
    public void example1() {
        String s = "YazaAay";
        String expected = "aAa";
        Assertions.assertEquals(expected, solution1763_v1.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v2.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v3.longestNiceSubstring(s));
    }

    @Test
    public void example2() {
        String s = "Bb";
        String expected = "Bb";
        Assertions.assertEquals(expected, solution1763_v1.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v2.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v3.longestNiceSubstring(s));
    }

    @Test
    public void example3() {
        String s = "c";
        String expected = "";
        Assertions.assertEquals(expected, solution1763_v1.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v2.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v3.longestNiceSubstring(s));
    }

    @Test
    public void example4() {
        String s = "dDzeE";
        String expected = "dD";
        Assertions.assertEquals(expected, solution1763_v1.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v2.longestNiceSubstring(s));
        Assertions.assertEquals(expected, solution1763_v3.longestNiceSubstring(s));
    }
}