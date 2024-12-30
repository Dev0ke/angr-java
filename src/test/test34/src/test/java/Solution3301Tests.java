import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3301Tests {
    private final Solution3301 solution3301 = new Solution3301();

    @Test
    public void example1() {
        int[] maximumHeight = {2, 3, 4, 3};
        long expected = 10;
        Assertions.assertEquals(expected, solution3301.maximumTotalSum(maximumHeight));
    }

    @Test
    public void example2() {
        int[] maximumHeight = {15, 10};
        long expected = 25;
        Assertions.assertEquals(expected, solution3301.maximumTotalSum(maximumHeight));
    }

    @Test
    public void example3() {
        int[] maximumHeight = {2, 2, 1};
        long expected = -1;
        Assertions.assertEquals(expected, solution3301.maximumTotalSum(maximumHeight));
    }
}