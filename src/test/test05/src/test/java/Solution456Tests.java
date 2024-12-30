import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution456Tests {
    private final Solution456 solution456 = new Solution456();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution456.find132pattern(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 4, 2};
        Assertions.assertTrue(solution456.find132pattern(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, 3, 2, 0};
        Assertions.assertTrue(solution456.find132pattern(nums));
    }
}
