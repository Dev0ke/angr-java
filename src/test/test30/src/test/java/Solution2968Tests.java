import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2968Tests {
    private final Solution2968 solution2968 = new Solution2968();

    @Test
    public void example1() {
        int[] nums = {1, 2, 6, 4};
        long k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2968.maxFrequencyScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 4, 2, 4};
        long k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution2968.maxFrequencyScore(nums, k));
    }
}