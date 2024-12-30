import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3115Tests {
    private final Solution3115 solution3115 = new Solution3115();

    @Test
    public void example1() {
        int[] nums = {4, 2, 9, 5, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution3115.maximumPrimeDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 8, 2, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solution3115.maximumPrimeDifference(nums));
    }
}