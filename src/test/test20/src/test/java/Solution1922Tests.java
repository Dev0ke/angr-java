import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1922Tests {
    private final Solution1922 solution1922 = new Solution1922();

    @Test
    public void example1() {
        long n = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution1922.countGoodNumbers(n));
    }

    @Test
    public void example2() {
        long n = 4;
        int expected = 400;
        Assertions.assertEquals(expected, solution1922.countGoodNumbers(n));
    }

    @Test
    public void example3() {
        long n = 50;
        int expected = 564908303;
        Assertions.assertEquals(expected, solution1922.countGoodNumbers(n));
    }
}
