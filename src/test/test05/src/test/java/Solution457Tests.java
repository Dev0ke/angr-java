import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution457Tests {
    private final Solution457 solution457 = new Solution457();

    @Test
    public void example1() {
        int[] nums = {2, -1, 1, 2, 2};
        Assertions.assertTrue(solution457.circularArrayLoop(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 2};
        Assertions.assertFalse(solution457.circularArrayLoop(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-2, 1, -1, -2, -2};
        Assertions.assertFalse(solution457.circularArrayLoop(nums));
    }
}