import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution13Tests {
    private final Solution13 solution13 = new Solution13();

    @Test
    public void example1() {
        String s = "III";
        int expected = 3;
        Assertions.assertEquals(expected, solution13.romanToInt(s));
    }

    @Test
    public void example2() {
        String s = "IV";
        int expected = 4;
        Assertions.assertEquals(expected, solution13.romanToInt(s));
    }

    @Test
    public void example3() {
        String s = "IX";
        int expected = 9;
        Assertions.assertEquals(expected, solution13.romanToInt(s));
    }

    @Test
    public void example4() {
        String s = "LVIII";
        int expected = 58;
        Assertions.assertEquals(expected, solution13.romanToInt(s));
    }

    @Test
    public void example5() {
        String s = "MCMXCIV";
        int expected = 1994;
        Assertions.assertEquals(expected, solution13.romanToInt(s));
    }
}
