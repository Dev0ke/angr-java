import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution268Tests {
    private final Solution268 solution268 = new Solution268();

    @Test
    public void example1() {
        int[] nums = {3, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution268.missingNumber(nums));
        Assertions.assertEquals(expected, solution268.missingNumber2(nums));
        Assertions.assertEquals(expected, solution268.missingNumber3(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution268.missingNumber(nums));
        Assertions.assertEquals(expected, solution268.missingNumber2(nums));
        Assertions.assertEquals(expected, solution268.missingNumber3(nums));
    }

    @Test
    public void example3() {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solution268.missingNumber(nums));
        Assertions.assertEquals(expected, solution268.missingNumber2(nums));
        Assertions.assertEquals(expected, solution268.missingNumber3(nums));
    }

    @Test
    public void example4() {
        int[] nums = {0};
        int expected = 1;
        Assertions.assertEquals(expected, solution268.missingNumber(nums));
        Assertions.assertEquals(expected, solution268.missingNumber2(nums));
        Assertions.assertEquals(expected, solution268.missingNumber3(nums));
    }
}
