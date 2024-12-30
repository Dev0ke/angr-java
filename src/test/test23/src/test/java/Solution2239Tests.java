import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2239Tests {
    private final Solution2239 solution2239 = new Solution2239();

    @Test
    public void example1() {
        int[] nums = {-4, -2, 1, 4, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution2239.findClosestNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, -1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution2239.findClosestNumber(nums));
    }
}
