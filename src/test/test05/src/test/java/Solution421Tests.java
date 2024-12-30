import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution421Tests {
    private final Solution421 solution421 = new Solution421();

    @Test
    public void example1() {
        int[] nums = {3, 10, 5, 25, 2, 8};
        int expected = 28;
        Assertions.assertEquals(expected, solution421.findMaximumXOR(nums));
        Assertions.assertEquals(expected, solution421.findMaximumXOR2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution421.findMaximumXOR(nums));
        Assertions.assertEquals(expected, solution421.findMaximumXOR2(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution421.findMaximumXOR(nums));
        Assertions.assertEquals(expected, solution421.findMaximumXOR2(nums));
    }

    @Test
    public void example4() {
        int[] nums = {8, 10, 2};
        int expected = 10;
        Assertions.assertEquals(expected, solution421.findMaximumXOR(nums));
        Assertions.assertEquals(expected, solution421.findMaximumXOR2(nums));
    }

    @Test
    public void example5() {
        int[] nums = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        int expected = 127;
        Assertions.assertEquals(expected, solution421.findMaximumXOR(nums));
        Assertions.assertEquals(expected, solution421.findMaximumXOR2(nums));
    }
}
