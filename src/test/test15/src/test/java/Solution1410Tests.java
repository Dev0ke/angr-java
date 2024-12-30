import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1410Tests {
    private final Solution1410 solution1410 = new Solution1410();

    @Test
    public void example1() {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        String expected = "& is an HTML entity but &ambassador; is not.";
        Assertions.assertEquals(expected, solution1410.entityParser(text));
        Assertions.assertEquals(expected, solution1410.entityParser2(text));
    }

    @Test
    public void example2() {
        String text = "and I quote: &quot;...&quot;";
        String expected = "and I quote: \"...\"";
        Assertions.assertEquals(expected, solution1410.entityParser(text));
        Assertions.assertEquals(expected, solution1410.entityParser2(text));
    }

    @Test
    public void example3() {
        String text = "Stay home! Practice on Leetcode :)";
        String expected = "Stay home! Practice on Leetcode :)";
        Assertions.assertEquals(expected, solution1410.entityParser(text));
        Assertions.assertEquals(expected, solution1410.entityParser2(text));
    }

    @Test
    public void example4() {
        String text = "x &gt; y &amp;&amp; x &lt; y is always false";
        String expected = "x > y && x < y is always false";
        Assertions.assertEquals(expected, solution1410.entityParser(text));
        Assertions.assertEquals(expected, solution1410.entityParser2(text));
    }

    @Test
    public void example5() {
        String text = "leetcode.com&frasl;problemset&frasl;all";
        String expected = "leetcode.com/problemset/all";
        Assertions.assertEquals(expected, solution1410.entityParser(text));
        Assertions.assertEquals(expected, solution1410.entityParser2(text));
    }
}