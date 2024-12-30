import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2789Tests {
    private final Solution2789 solution2789 = new Solution2789();

    @Test
    public void example1() {
        int[] nums = {2, 3, 7, 9, 3};
        long expected = 21;
        Assertions.assertEquals(expected, solution2789.maxArrayValue(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 3, 3};
        long expected = 11;
        Assertions.assertEquals(expected, solution2789.maxArrayValue(nums));
    }
}