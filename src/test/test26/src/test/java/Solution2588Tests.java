import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2588Tests {
    private final Solution2588 solution2588 = new Solution2588();

    @Test
    public void example1() {
        int[] nums = {4, 3, 1, 2, 4};
        long expected = 2;
        Assertions.assertEquals(expected, solution2588.beautifulSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 10, 4};
        long expected = 0;
        Assertions.assertEquals(expected, solution2588.beautifulSubarrays(nums));
    }
}