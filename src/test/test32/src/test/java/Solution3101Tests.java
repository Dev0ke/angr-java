import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3101Tests {
    private final Solution3101 solution3101 = new Solution3101();

    @Test
    public void example1() {
        int[] nums = {0, 1, 1, 1};
        long expected = 5;
        Assertions.assertEquals(expected, solution3101.countAlternatingSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 0, 1, 0};
        long expected = 10;
        Assertions.assertEquals(expected, solution3101.countAlternatingSubarrays(nums));
    }
}