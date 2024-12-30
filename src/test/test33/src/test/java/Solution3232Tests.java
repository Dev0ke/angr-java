import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3232Tests {
    private final Solution3232 solution3232 = new Solution3232();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 10};
        Assertions.assertFalse(solution3232.canAliceWin(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5, 14};
        Assertions.assertTrue(solution3232.canAliceWin(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 5, 5, 25};
        Assertions.assertTrue(solution3232.canAliceWin(nums));
    }
}