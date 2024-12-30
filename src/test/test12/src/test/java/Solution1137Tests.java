import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1137Tests {
    private final Solution1137 solution1137 = new Solution1137();

    @Test
    public void example1() {
        int n = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution1137.tribonacci(n));
    }

    @Test
    public void example2() {
        int n = 25;
        int expected = 1389537;
        Assertions.assertEquals(expected, solution1137.tribonacci(n));
    }
}
