import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1323Tests {
    private final Solution1323 solution1323 = new Solution1323();

    @Test
    public void example1() {
        int num = 9669;
        int expected = 9969;
        Assertions.assertEquals(expected, solution1323.maximum69Number(num));
    }

    @Test
    public void example2() {
        int num = 9996;
        int expected = 9999;
        Assertions.assertEquals(expected, solution1323.maximum69Number(num));
    }

    @Test
    public void example3() {
        int num = 9999;
        int expected = 9999;
        Assertions.assertEquals(expected, solution1323.maximum69Number(num));
    }
}