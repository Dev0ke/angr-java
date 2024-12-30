import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution992Tests {
    private final Solution992 solution992 = new Solution992();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution992.subarraysWithKDistinct(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 3, 4};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution992.subarraysWithKDistinct(nums, k));
    }
}
