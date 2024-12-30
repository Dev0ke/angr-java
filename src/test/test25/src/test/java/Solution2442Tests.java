import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2442Tests {
    private final Solution2442 solution2442 = new Solution2442();

    @Test
    public void example1() {
        int[] nums = {1, 13, 10, 12, 31};
        int expected = 6;
        Assertions.assertEquals(expected, solution2442.countDistinctIntegers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution2442.countDistinctIntegers(nums));
    }
}
