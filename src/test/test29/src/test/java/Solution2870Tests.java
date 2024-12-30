import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2870Tests {
    private final Solution2870 solution2870 = new Solution2870();

    @Test
    public void example1() {
        int[] nums = {2, 3, 3, 2, 2, 4, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2870.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 2, 2, 3, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2870.minOperations(nums));
    }
}