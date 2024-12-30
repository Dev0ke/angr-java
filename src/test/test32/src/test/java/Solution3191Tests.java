import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3191Tests {
    private final Solution3191 solution3191 = new Solution3191();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 1, 0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution3191.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 1, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solution3191.minOperations(nums));
    }
}