import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution70Tests {
    private final Solution70 solution70 = new Solution70();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution70.climbStairs(n));
        Assertions.assertEquals(expected, solution70.climbStairs2(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution70.climbStairs(n));
        Assertions.assertEquals(expected, solution70.climbStairs2(n));
    }
}
