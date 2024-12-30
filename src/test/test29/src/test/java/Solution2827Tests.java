import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2827Tests {
    private final Solution2827 solution2827 = new Solution2827();

    @Test
    public void example1() {
        int low = 10;
        int high = 20;
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution2827.numberOfBeautifulIntegers(low, high, k));
    }

    @Test
    public void example2() {
        int low = 1;
        int high = 10;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2827.numberOfBeautifulIntegers(low, high, k));
    }

    @Test
    public void example3() {
        int low = 5;
        int high = 5;
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2827.numberOfBeautifulIntegers(low, high, k));
    }
}