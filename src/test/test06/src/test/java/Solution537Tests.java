import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution537Tests {
    private final Solution537 solution537 = new Solution537();

    @Test
    public void example1() {
        String num1 = "1+1i";
        String num2 = "1+1i";
        String expected = "0+2i";
        Assertions.assertEquals(expected, solution537.complexNumberMultiply(num1, num2));
    }

    @Test
    public void example2() {
        String num1 = "1+-1i";
        String num2 = "1+-1i";
        String expected = "0+-2i";
        Assertions.assertEquals(expected, solution537.complexNumberMultiply(num1, num2));
    }

    // 补充用例
    @Test
    public void example3() {
        String num1 = "78+-76i";
        String num2 = "-86+72i";
        String expected = "-1236+12152i";
        Assertions.assertEquals(expected, solution537.complexNumberMultiply(num1, num2));
    }
}

