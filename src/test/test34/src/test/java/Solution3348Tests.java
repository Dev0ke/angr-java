import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3348Tests {
    private final Solution3348 solution3348 = new Solution3348();

    @Test
    public void example1() {
        String num = "1234";
        long t = 256;
        String expected = "1488";
        Assertions.assertEquals(expected, solution3348.smallestNumber(num, t));
    }

    @Test
    public void example2() {
        String num = "12355";
        long t = 50;
        String expected = "12355";
        Assertions.assertEquals(expected, solution3348.smallestNumber(num, t));
    }

    @Test
    public void example3() {
        String num = "11111";
        long t = 26;
        String expected = "-1";
        Assertions.assertEquals(expected, solution3348.smallestNumber(num, t));
    }
}