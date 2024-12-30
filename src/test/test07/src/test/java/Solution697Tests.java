import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution697Tests {
    private final Solution697 solution697 = new Solution697();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution697.findShortestSubArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution697.findShortestSubArray(nums));
    }
}