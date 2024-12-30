import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution219Tests {
    private final Solution219 solution219 = new Solution219();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        Assertions.assertTrue(solution219.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        Assertions.assertTrue(solution219.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        Assertions.assertFalse(solution219.containsNearbyDuplicate(nums, k));
    }
}
