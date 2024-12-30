import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution334Tests {
    private final Solution334 solution334 = new Solution334();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solution334.increasingTriplet(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 3, 2, 1};
        Assertions.assertFalse(solution334.increasingTriplet(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 1, 5, 0, 4, 6};
        Assertions.assertTrue(solution334.increasingTriplet(nums));
    }
}
