import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2572Tests {
    private final Solution2572 solution2572 = new Solution2572();

    @Test
    public void example1() {
        int[] nums = {3, 4, 4, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution2572.squareFreeSubsets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution2572.squareFreeSubsets(nums));
    }
}