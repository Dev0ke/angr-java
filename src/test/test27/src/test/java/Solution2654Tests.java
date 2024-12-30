import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2654Tests {
    private final Solution2654 solution2654 = new Solution2654();

    @Test
    public void example1() {
        int[] nums = {2, 6, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2654.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 10, 6, 14};
        int expected = -1;
        Assertions.assertEquals(expected, solution2654.minOperations(nums));
    }
}