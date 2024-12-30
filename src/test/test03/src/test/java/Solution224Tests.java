import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution224Tests {
    private final Solution224 solution224 = new Solution224();

    @Test
    public void example1() {
        String s = "1 + 1";
        int expected = 2;
        Assertions.assertEquals(expected, solution224.calculate(s));
    }

    @Test
    public void example2() {
        String s = " 2-1 + 2 ";
        int expected = 3;
        Assertions.assertEquals(expected, solution224.calculate(s));
    }

    @Test
    public void example3() {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int expected = 23;
        Assertions.assertEquals(expected, solution224.calculate(s));
    }
}
