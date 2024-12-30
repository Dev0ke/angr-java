import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution560Tests {
    private final Solution560 solution560 = new Solution560();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution560.subarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution560.subarraySum(nums, k));
    }
}
