import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3300Tests {
    private final Solution3300 solution3300 = new Solution3300();

    @Test
    public void example1() {
        int[] nums = {10, 12, 13, 14};
        int expected = 1;
        Assertions.assertEquals(expected, solution3300.minElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3300.minElement(nums));
    }

    @Test
    public void example3() {
        int[] nums = {999, 19, 199};
        int expected = 10;
        Assertions.assertEquals(expected, solution3300.minElement(nums));
    }
}