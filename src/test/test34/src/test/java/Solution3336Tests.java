import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3336Tests {
    private final Solution3336 solution3336 = new Solution3336();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 10;
        Assertions.assertEquals(expected, solution3336.subsequencePairCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 30};
        int expected = 2;
        Assertions.assertEquals(expected, solution3336.subsequencePairCount(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1};
        int expected = 50;
        Assertions.assertEquals(expected, solution3336.subsequencePairCount(nums));
    }
}