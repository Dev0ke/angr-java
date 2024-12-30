import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution166Tests {
    private final Solution166 solution166 = new Solution166();

    @Test
    public void example1() {
        int numerator = 1;
        int denominator = 2;
        String expected = "0.5";
        Assertions.assertEquals(expected, solution166.fractionToDecimal(numerator, denominator));
    }

    @Test
    public void example2() {
        int numerator = 2;
        int denominator = 1;
        String expected = "2";
        Assertions.assertEquals(expected, solution166.fractionToDecimal(numerator, denominator));
    }

    @Test
    public void example3() {
        int numerator = 2;
        int denominator = 3;
        String expected = "0.(6)";
        Assertions.assertEquals(expected, solution166.fractionToDecimal(numerator, denominator));
    }

    @Test
    public void example4() {
        int numerator = 4;
        int denominator = 333;
        String expected = "0.(012)";
        Assertions.assertEquals(expected, solution166.fractionToDecimal(numerator, denominator));
    }

    @Test
    public void example5() {
        int numerator = 1;
        int denominator = 5;
        String expected = "0.2";
        Assertions.assertEquals(expected, solution166.fractionToDecimal(numerator, denominator));
    }
}
