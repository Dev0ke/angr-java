import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2302Tests {
    private final Solution2302 solution2302 = new Solution2302();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4, 3, 5};
        long k = 10;
        long expected = 6;
        Assertions.assertEquals(expected, solution2302.countSubarrays(nums, k));
        Assertions.assertEquals(expected, solution2302.countSubarrays2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        long k = 5;
        long expected = 5;
        Assertions.assertEquals(expected, solution2302.countSubarrays(nums, k));
        Assertions.assertEquals(expected, solution2302.countSubarrays2(nums, k));
    }
}
