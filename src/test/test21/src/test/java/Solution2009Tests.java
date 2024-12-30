import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2009Tests {
    private final Solution2009 solution2009 = new Solution2009();

    @Test
    public void example1() {
        int[] nums = {4, 2, 5, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution2009.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 5, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution2009.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 10, 100, 1000};
        int expected = 3;
        Assertions.assertEquals(expected, solution2009.minOperations(nums));
    }
}