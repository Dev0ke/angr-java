import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution12Tests {
    private final Solution12 solution12 = new Solution12();

    @Test
    public void example1() {
        int num = 3;
        String expected = "III";
        Assertions.assertEquals(expected, solution12.intToRoman(num));
    }

    @Test
    public void example2() {
        int num = 4;
        String expected = "IV";
        Assertions.assertEquals(expected, solution12.intToRoman(num));
    }

    @Test
    public void example3() {
        int num = 9;
        String expected = "IX";
        Assertions.assertEquals(expected, solution12.intToRoman(num));
    }

    @Test
    public void example4() {
        int num = 58;
        String expected = "LVIII";
        Assertions.assertEquals(expected, solution12.intToRoman(num));
    }

    @Test
    public void example5() {
        int num = 1994;
        String expected = "MCMXCIV";
        Assertions.assertEquals(expected, solution12.intToRoman(num));
    }
}
