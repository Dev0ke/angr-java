import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2765Tests {
    private final Solution2765 solution2765 = new Solution2765();

    @Test
    public void example1() {
        int[] nums = {2, 3, 4, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2765.alternatingSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solution2765.alternatingSubarray(nums));
    }
}