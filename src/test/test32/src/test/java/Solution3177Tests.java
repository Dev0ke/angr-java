import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3177Tests {
    private final Solution3177 solution3177 = new Solution3177();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3177.maximumLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5, 1};
        int k = 0;
        int expected = 2;
        Assertions.assertEquals(expected, solution3177.maximumLength(nums, k));
    }
}