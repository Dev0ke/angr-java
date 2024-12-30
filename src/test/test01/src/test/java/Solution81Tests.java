import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution81Tests {
    private final Solution81 solution81 = new Solution81();

    @Test
    public void example1() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        Assertions.assertTrue(solution81.search(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 3;
        Assertions.assertFalse(solution81.search(nums, target));
    }
}
