import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution592Tests {
    private final Solution592 solution592 = new Solution592();

    @Test
    public void example1() {
        String expression = "-1/2+1/2";
        String expected = "0/1";
        Assertions.assertEquals(expected, solution592.fractionAddition(expression));
    }

    @Test
    public void example2() {
        String expression = "-1/2+1/2+1/3";
        String expected = "1/3";
        Assertions.assertEquals(expected, solution592.fractionAddition(expression));
    }

    @Test
    public void example3() {
        String expression = "1/3-1/2";
        String expected = "-1/6";
        Assertions.assertEquals(expected, solution592.fractionAddition(expression));
    }
}
