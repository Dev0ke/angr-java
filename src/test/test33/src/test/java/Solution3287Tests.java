import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3287Tests {
    private final Solution3287 solution3287 = new Solution3287();

    @Test
    public void example1() {
        int[] nums = {2, 6, 7};
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution3287.maxValue(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 5, 6, 7};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3287.maxValue(nums, k));
    }
}