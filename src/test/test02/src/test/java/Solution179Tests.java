import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution179Tests {
    private final Solution179 solution179 = new Solution179();

    @Test
    public void example1() {
        int[] nums = {10, 2};
        String expected = "210";
        Assertions.assertEquals(expected, solution179.largestNumber(nums));
        Assertions.assertEquals(expected, solution179.largestNumber2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 30, 34, 5, 9};
        String expected = "9534330";
        Assertions.assertEquals(expected, solution179.largestNumber(nums));
        Assertions.assertEquals(expected, solution179.largestNumber2(nums));
    }
}
