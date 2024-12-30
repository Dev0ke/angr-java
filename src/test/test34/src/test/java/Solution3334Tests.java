import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3334Tests {
    private final Solution3334 solution3334 = new Solution3334();

    @Test
    public void example1() {
        int[] nums = {2, 4, 8, 16};
        long expected = 64;
        Assertions.assertEquals(expected, solution3334.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 60;
        Assertions.assertEquals(expected, solution3334.maxScore(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3};
        long expected = 9;
        Assertions.assertEquals(expected, solution3334.maxScore(nums));
    }
}