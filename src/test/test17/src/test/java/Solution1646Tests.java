import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1646Tests {
    private final Solution1646 solution1646 = new Solution1646();

    @Test
    public void example1() {
        int n = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution1646.getMaximumGenerated(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1646.getMaximumGenerated(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution1646.getMaximumGenerated(n));
    }
}