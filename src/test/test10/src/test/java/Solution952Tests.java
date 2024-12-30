import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution952Tests {
    private final Solution952 solution952 = new Solution952();

    @Test
    public void example1() {
        int[] nums = {4, 6, 15, 35};
        int expected = 4;
        Assertions.assertEquals(expected, solution952.largestComponentSize(nums));
    }

    @Test
    public void example2() {
        int[] nums = {20, 50, 9, 63};
        int expected = 2;
        Assertions.assertEquals(expected, solution952.largestComponentSize(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 6, 7, 4, 12, 21, 39};
        int expected = 8;
        Assertions.assertEquals(expected, solution952.largestComponentSize(nums));
    }
}
