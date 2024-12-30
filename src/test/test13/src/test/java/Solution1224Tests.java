import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1224Tests {
    private final Solution1224 solution1224 = new Solution1224();

    @Test
    public void example1() {
        int[] nums = {2, 2, 1, 1, 5, 3, 3, 5};
        int expected = 7;
        Assertions.assertEquals(expected, solution1224.maxEqualFreq(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        int expected = 13;
        Assertions.assertEquals(expected, solution1224.maxEqualFreq(nums));
    }
}
