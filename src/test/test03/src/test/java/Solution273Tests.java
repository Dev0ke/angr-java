import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution273Tests {
    private final Solution273 solution273 = new Solution273();

    @Test
    public void example1() {
        int num = 123;
        String expected = "One Hundred Twenty Three";
        Assertions.assertEquals(expected, solution273.numberToWords(num));
    }

    @Test
    public void example2() {
        int num = 12345;
        String expected = "Twelve Thousand Three Hundred Forty Five";
        Assertions.assertEquals(expected, solution273.numberToWords(num));
    }

    @Test
    public void example3() {
        int num = 1234567;
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        Assertions.assertEquals(expected, solution273.numberToWords(num));
    }

    @Test
    public void example4() {
        int num = 1234567891;
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        Assertions.assertEquals(expected, solution273.numberToWords(num));
    }
}
