import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2447Tests {
    private final Solution2447 solution2447 = new Solution2447();

    @Test
    public void example1() {
        int[] nums = {9, 3, 1, 2, 6, 3};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution2447.subarrayGCD(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4};
        int k = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution2447.subarrayGCD(nums, k));
    }
}
