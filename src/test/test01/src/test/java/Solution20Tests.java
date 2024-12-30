import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution20Tests {
    private final Solution20 solution20 = new Solution20();

    @Test
    public void example1() {
        String s = "()";
        Assertions.assertTrue(solution20.isValid(s));
    }

    @Test
    public void example2() {
        String s = "()[]{}";
        Assertions.assertTrue(solution20.isValid(s));
    }

    @Test
    public void example3() {
        String s = "(]";
        Assertions.assertFalse(solution20.isValid(s));
    }

    @Test
    public void example4() {
        String s = "([)]";
        Assertions.assertFalse(solution20.isValid(s));
    }

    @Test
    public void example5() {
        String s = "{[]}";
        Assertions.assertTrue(solution20.isValid(s));
    }
}
