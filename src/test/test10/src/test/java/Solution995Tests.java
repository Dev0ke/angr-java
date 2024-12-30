import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution995Tests {
    private final Solution995 solution995 = new Solution995();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution995.minKBitFlips(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 0};
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution995.minKBitFlips(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution995.minKBitFlips(nums, k));
    }
}
