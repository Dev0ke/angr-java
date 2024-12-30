import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution55Tests {
    private final Solution55 solution55 = new Solution55();

    @Test
    public void example1() {
        int[] nums = {2, 3, 1, 1, 4};
        Assertions.assertTrue(solution55.canJump(nums));
        Assertions.assertTrue(solution55.canJump2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1, 0, 4};
        Assertions.assertFalse(solution55.canJump(nums));
        Assertions.assertFalse(solution55.canJump2(nums));
    }
}
