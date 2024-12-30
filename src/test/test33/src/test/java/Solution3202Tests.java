import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3202Tests {
    private final Solution3202 solution3202 = new Solution3202();
    private final Solution3202.V2 solution100358_v2 = new Solution3202.V2();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution3202.maximumLength(nums, k));
        Assertions.assertEquals(expected, solution100358_v2.maximumLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 3, 1, 4};
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3202.maximumLength(nums, k));
        Assertions.assertEquals(expected, solution100358_v2.maximumLength(nums, k));
    }
}