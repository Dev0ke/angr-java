import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1556Tests {
    private final Solution1556 solution1556 = new Solution1556();

    @Test
    public void example1() {
        int n = 987;
        String expected = "987";
        Assertions.assertEquals(expected, solution1556.thousandSeparator(n));
    }

    @Test
    public void example2() {
        int n = 1234;
        String expected = "1.234";
        Assertions.assertEquals(expected, solution1556.thousandSeparator(n));
    }

    @Test
    public void example3() {
        int n = 123456789;
        String expected = "123.456.789";
        Assertions.assertEquals(expected, solution1556.thousandSeparator(n));
    }

    @Test
    public void example4() {
        int n = 0;
        String expected = "0";
        Assertions.assertEquals(expected, solution1556.thousandSeparator(n));
    }
}