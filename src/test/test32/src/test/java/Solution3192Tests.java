import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3192Tests {
    private final Solution3192 solution3192 = new Solution3192();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 0, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3192.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution3192.minOperations(nums));
    }
}