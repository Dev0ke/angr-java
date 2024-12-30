import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution581Tests {
    private final Solution581 solution581 = new Solution581();

    @Test
    public void example1() {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int expected = 5;
        Assertions.assertEquals(expected, solution581.findUnsortedSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution581.findUnsortedSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution581.findUnsortedSubarray(nums));
    }
}