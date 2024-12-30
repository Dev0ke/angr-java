import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1249Tests {
    private final Solution1249 solution1249 = new Solution1249();

    @Test
    public void example1() {
        String s = "lee(t(c)o)de)";
        String expected = "lee(t(c)o)de";
        Assertions.assertEquals(expected, solution1249.minRemoveToMakeValid(s));
    }

    @Test
    public void example2() {
        String s = "a)b(c)d";
        String expected = "ab(c)d";
        Assertions.assertEquals(expected, solution1249.minRemoveToMakeValid(s));
    }

    @Test
    public void example3() {
        String s = "))((";
        String expected = "";
        Assertions.assertEquals(expected, solution1249.minRemoveToMakeValid(s));
    }

    @Test
    public void example4() {
        String s = "(a(b(c)d)";
        String expected = "a(b(c)d)";
        Assertions.assertEquals(expected, solution1249.minRemoveToMakeValid(s));
    }

    @Test
    public void example5() {
        String s = "())()(((";
        String expected = "()()";
        Assertions.assertEquals(expected, solution1249.minRemoveToMakeValid(s));
    }

}
