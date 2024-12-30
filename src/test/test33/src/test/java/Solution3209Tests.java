import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3209Tests {
    private final Solution3209 solution3209 = new Solution3209();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int k = 1;
        long expected = 6;
        Assertions.assertEquals(expected, solution3209.countSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2};
        int k = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution3209.countSubarrays(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int k = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solution3209.countSubarrays(nums, k));
    }
}