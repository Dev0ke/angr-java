import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2571Tests {
    private final Solution2571 solution2571 = new Solution2571();

    @Test
    public void example1() {
        int n = 39;
        int expected = 3;
        Assertions.assertEquals(expected, solution2571.minOperations(n));
    }

    @Test
    public void example2() {
        int n = 54;
        int expected = 3;
        Assertions.assertEquals(expected, solution2571.minOperations(n));
    }
}