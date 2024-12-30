import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2587Tests {
    private final Solution2587 solution2587 = new Solution2587();

    @Test
    public void example1() {
        int[] nums = {2, -1, 0, 1, -3, 3, -3};
        int expected = 6;
        Assertions.assertEquals(expected, solution2587.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-2, -3, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution2587.maxScore(nums));
    }
}