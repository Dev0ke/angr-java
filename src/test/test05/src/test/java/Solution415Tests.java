import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution415Tests {
    private final Solution415 solution415 = new Solution415();

    @Test
    public void example1() {
        String num1 = "11";
        String num2 = "123";
        String expected = "134";
        Assertions.assertEquals(expected, solution415.addStrings(num1, num2));
        Assertions.assertEquals(expected, solution415.addStrings2(num1, num2));
    }

    @Test
    public void example2() {
        String num1 = "456";
        String num2 = "77";
        String expected = "533";
        Assertions.assertEquals(expected, solution415.addStrings(num1, num2));
        Assertions.assertEquals(expected, solution415.addStrings2(num1, num2));
    }

    @Test
    public void example3() {
        String num1 = "0";
        String num2 = "0";
        String expected = "0";
        Assertions.assertEquals(expected, solution415.addStrings(num1, num2));
        Assertions.assertEquals(expected, solution415.addStrings2(num1, num2));
    }
}
