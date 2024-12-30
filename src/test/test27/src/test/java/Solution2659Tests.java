import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2659Tests {
    private final Solution2659 solution2659 = new Solution2659();

    @Test
    public void example1() {
        int[] nums = {3, 4, -1};
        long expected = 5;
        Assertions.assertEquals(expected, solution2659.countOperationsToEmptyArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution2659.countOperationsToEmptyArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        long expected = 3;
        Assertions.assertEquals(expected, solution2659.countOperationsToEmptyArray(nums));
    }
}