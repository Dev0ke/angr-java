import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2593Tests {
    private final Solution2593 solution2593 = new Solution2593();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3, 4, 5, 2};
        long expected = 7;
        Assertions.assertEquals(expected, solution2593.findScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 1, 3, 2};
        long expected = 5;
        Assertions.assertEquals(expected, solution2593.findScore(nums));
    }
}