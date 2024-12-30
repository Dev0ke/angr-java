import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution150Tests {
    private final Solution150 solution150 = new Solution150();

    @Test
    public void example1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int expected = 9;
        Assertions.assertEquals(expected, solution150.evalRPN(tokens));
    }

    @Test
    public void example2() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        int expected = 6;
        Assertions.assertEquals(expected, solution150.evalRPN(tokens));
    }

    @Test
    public void example3() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expected = 22;
        Assertions.assertEquals(expected, solution150.evalRPN(tokens));
    }
}
