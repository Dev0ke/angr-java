import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2259Tests {
    private final Solution2259 solution2259 = new Solution2259();

    @Test
    public void example1() {
        String number = "123";
        char digit = '3';
        String expected = "12";
        Assertions.assertEquals(expected, solution2259.removeDigit(number, digit));
    }

    @Test
    public void example2() {
        String number = "1231";
        char digit = '1';
        String expected = "231";
        Assertions.assertEquals(expected, solution2259.removeDigit(number, digit));
    }

    @Test
    public void example3() {
        String number = "551";
        char digit = '5';
        String expected = "51";
        Assertions.assertEquals(expected, solution2259.removeDigit(number, digit));
    }
}
