import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1061Tests {
    private final Solution1061 solution1061 = new Solution1061();

    @Test
    public void example1() {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";
        String expected = "makkek";
        Assertions.assertEquals(expected, solution1061.smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    public void example2() {
        String s1 = "hello";
        String s2 = "world";
        String baseStr = "hold";
        String expected = "hdld";
        Assertions.assertEquals(expected, solution1061.smallestEquivalentString(s1, s2, baseStr));
    }

    @Test
    public void example3() {
        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";
        String expected = "aauaaaaada";
        Assertions.assertEquals(expected, solution1061.smallestEquivalentString(s1, s2, baseStr));
    }
}
