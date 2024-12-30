import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution43Tests {
    private final Solution43 solution43 = new Solution43();

    @Test
    public void example1() {
        String num1 = "2";
        String num2 = "3";
        String expected = "6";
        Assertions.assertEquals(expected, solution43.multiply(num1, num2));
    }

    @Test
    public void example2() {
        String num1 = "123";
        String num2 = "456";
        String expected = "56088";
        Assertions.assertEquals(expected, solution43.multiply(num1, num2));
    }
}
