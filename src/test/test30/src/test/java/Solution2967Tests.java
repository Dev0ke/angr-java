import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2967Tests {
    private final Solution2967 solution2967 = new Solution2967();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 6;
        Assertions.assertEquals(expected, solution2967.minimumCost(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 12, 13, 14, 15};
        long expected = 11;
        Assertions.assertEquals(expected, solution2967.minimumCost(nums));
    }

    @Test
    public void example3() {
        int[] nums = {22, 33, 22, 33, 22};
        long expected = 22;
        Assertions.assertEquals(expected, solution2967.minimumCost(nums));
    }
}