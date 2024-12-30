import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution477Tests {
    private final Solution477 solution477 = new Solution477();

    @Test
    public void example1() {
        int[] nums = {4, 14, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution477.totalHammingDistance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 14, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution477.totalHammingDistance(nums));
    }
}