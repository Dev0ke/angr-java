import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution220Tests {
    private final Solution220 solution220 = new Solution220();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        Assertions.assertTrue(solution220.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        int t = 2;
        Assertions.assertTrue(solution220.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @Test
    public void example3() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        Assertions.assertFalse(solution220.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
