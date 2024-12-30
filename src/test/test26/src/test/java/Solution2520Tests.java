import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2520Tests {
    private final Solution2520 solution2520 = new Solution2520();

    @Test
    public void example1() {
        int num = 7;
        int expected = 1;
        Assertions.assertEquals(expected, solution2520.countDigits(num));
    }

    @Test
    public void example2() {
        int num = 121;
        int expected = 2;
        Assertions.assertEquals(expected, solution2520.countDigits(num));
    }

    @Test
    public void example3() {
        int num = 1248;
        int expected = 4;
        Assertions.assertEquals(expected, solution2520.countDigits(num));
    }
}
