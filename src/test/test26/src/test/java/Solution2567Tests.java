import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2567Tests {
    private final Solution2567 solution2567 = new Solution2567();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solution2567.minimizeSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 7, 8, 5};
        int expected = 3;
        Assertions.assertEquals(expected, solution2567.minimizeSum(nums));
    }
}