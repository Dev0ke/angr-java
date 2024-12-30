import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2549Tests {
    private final Solution2549 solution2549 = new Solution2549();

    @Test
    public void example1() {
        int n = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution2549.distinctIntegers(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution2549.distinctIntegers(n));
    }
}