import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2507Tests {
    private final Solution2507 solution2507 = new Solution2507();

    @Test
    public void example1() {
        int n = 15;
        int expected = 5;
        Assertions.assertEquals(expected, solution2507.smallestValue(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2507.smallestValue(n));
    }
}