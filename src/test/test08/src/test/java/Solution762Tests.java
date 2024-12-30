import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution762Tests {
    private final Solution762 solution762 = new Solution762();

    @Test
    public void example1() {
        int left = 6;
        int right = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution762.countPrimeSetBits(left, right));
    }

    @Test
    public void example2() {
        int left = 10;
        int right = 15;
        int expected = 5;
        Assertions.assertEquals(expected, solution762.countPrimeSetBits(left, right));
    }
}
