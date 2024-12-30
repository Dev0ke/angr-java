import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2762Tests {
    private final Solution2762 solution2762 = new Solution2762();

    @Test
    public void example1() {
        int[] nums = {5, 4, 2, 4};
        long expected = 8;
        Assertions.assertEquals(expected, solution2762.continuousSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        long expected = 6;
        Assertions.assertEquals(expected, solution2762.continuousSubarrays(nums));
    }
}