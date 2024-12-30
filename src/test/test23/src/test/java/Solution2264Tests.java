import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2264Tests {
    private final Solution2264 solution2264 = new Solution2264();

    @Test
    public void example1() {
        String num = "6777133339";
        String expected = "777";
        Assertions.assertEquals(expected, solution2264.largestGoodInteger(num));
    }

    @Test
    public void example2() {
        String num = "2300019";
        String expected = "000";
        Assertions.assertEquals(expected, solution2264.largestGoodInteger(num));
    }

    @Test
    public void example3() {
        String num = "42352338";
        String expected = "";
        Assertions.assertEquals(expected, solution2264.largestGoodInteger(num));
    }
}
