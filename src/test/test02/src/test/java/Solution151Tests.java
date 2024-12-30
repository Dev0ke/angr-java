import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution151Tests {
    private final Solution151 solution151 = new Solution151();

    @Test
    public void example1() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        Assertions.assertEquals(expected, solution151.reverseWords(s));
    }

    @Test
    public void example2() {
        String s = "  hello world!  ";
        String expected = "world! hello";
        Assertions.assertEquals(expected, solution151.reverseWords(s));
    }

    @Test
    public void example3() {
        String s = "a good   example";
        String expected = "example good a";
        Assertions.assertEquals(expected, solution151.reverseWords(s));
    }

    @Test
    public void example4() {
        String s = "  Bob    Loves  Alice   ";
        String expected = "Alice Loves Bob";
        Assertions.assertEquals(expected, solution151.reverseWords(s));
    }
}
