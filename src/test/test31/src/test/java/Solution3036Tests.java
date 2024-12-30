import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3036Tests {
    private final Solution3036 solution3036 = new Solution3036();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] pattern = {1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution3036.countMatchingSubarrays(nums, pattern));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern = {1, 0, -1};
        int expected = 2;
        Assertions.assertEquals(expected, solution3036.countMatchingSubarrays(nums, pattern));
    }
}