import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution795Tests {
    private final Solution795 solution795 = new Solution795();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4, 3};
        int left = 2;
        int right = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution795.numSubarrayBoundedMax(nums, left, right));
    }

    @Test
    public void example2() {
        int[] nums = {2, 9, 2, 5, 6};
        int left = 2;
        int right = 8;
        int expected = 7;
        Assertions.assertEquals(expected, solution795.numSubarrayBoundedMax(nums, left, right));
    }
}
