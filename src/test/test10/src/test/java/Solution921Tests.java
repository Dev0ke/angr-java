import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution921Tests {
    private final Solution921 solution921 = new Solution921();

    @Test
    public void example1() {
        String s = "())";
        int expected = 1;
        Assertions.assertEquals(expected, solution921.minAddToMakeValid(s));
    }

    @Test
    public void example2() {
        String s = "(((";
        int expected = 3;
        Assertions.assertEquals(expected, solution921.minAddToMakeValid(s));
    }

    @Test
    public void example3() {
        String s = "()";
        int expected = 0;
        Assertions.assertEquals(expected, solution921.minAddToMakeValid(s));
    }

    @Test
    public void example4() {
        String s = "()))((";
        int expected = 4;
        Assertions.assertEquals(expected, solution921.minAddToMakeValid(s));
    }
}
