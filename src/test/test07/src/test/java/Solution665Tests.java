import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution665Tests {
    private final Solution665 solution665 = new Solution665();

    @Test
    public void example1() {
        int[] nums = {4, 2, 3};
        Assertions.assertTrue(solution665.checkPossibility(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 1};
        Assertions.assertFalse(solution665.checkPossibility(nums));
    }
}
