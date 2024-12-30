import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution682Tests {
    private final Solution682 solution682 = new Solution682();

    @Test
    public void example1() {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int expected = 27;
        Assertions.assertEquals(expected, solution682.calPoints(ops));
    }

    @Test
    public void example2() {
        String[] ops = {"1"};
        int expected = 1;
        Assertions.assertEquals(expected, solution682.calPoints(ops));
    }
}
