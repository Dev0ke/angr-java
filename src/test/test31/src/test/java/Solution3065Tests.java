import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3065Tests {
    private final Solution3065 solution3065 = new Solution3065();

    @Test
    public void example1() {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution3065.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 4, 9};
        int k = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution3065.minOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 4, 9};
        int k = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solution3065.minOperations(nums, k));
    }
}