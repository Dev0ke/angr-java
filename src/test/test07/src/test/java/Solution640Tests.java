import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution640Tests {
    private final Solution640 solution640 = new Solution640();

    @Test
    public void example1() {
        String equation = "x+5-3+x=6+x-2";
        String expected = "x=2";
        Assertions.assertEquals(expected, solution640.solveEquation(equation));
    }

    @Test
    public void example2() {
        String equation = "x=x";
        String expected = "Infinite solutions";
        Assertions.assertEquals(expected, solution640.solveEquation(equation));
    }

    @Test
    public void example3() {
        String equation = "2x=x";
        String expected = "x=0";
        Assertions.assertEquals(expected, solution640.solveEquation(equation));
    }
}