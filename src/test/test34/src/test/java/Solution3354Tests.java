import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3354Tests {
    private final Solution3354 solution3354 = new Solution3354();

    @Test
    public void example1() {
        int[] nums = {1, 0, 2, 0, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3354.countValidSelections(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 0, 4, 1, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution3354.countValidSelections(nums));
    }
}