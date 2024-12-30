import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2740Tests {
    private final Solution2740 solution2740 = new Solution2740();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution2740.findValueOfPartition(nums));
    }

    @Test
    public void example2() {
        int[] nums = {100, 1, 10};
        int expected = 9;
        Assertions.assertEquals(expected, solution2740.findValueOfPartition(nums));
    }
}