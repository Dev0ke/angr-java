import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2916Tests {
    private final Solution2916 solution2916 = new Solution2916();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int expected = 15;
        Assertions.assertEquals(expected, solution2916.sumCounts(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution2916.sumCounts(nums));
    }
}