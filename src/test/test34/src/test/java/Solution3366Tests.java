import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3366Tests {
    private final Solution3366 solution3366 = new Solution3366();

    @Test
    public void example1() {
        int[] nums = {2, 8, 3, 19, 3};
        int k = 3;
        int op1 = 1;
        int op2 = 1;
        int expected = 23;
        Assertions.assertEquals(expected, solution3366.minArraySum(nums, k, op1, op2));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 3};
        int k = 3;
        int op1 = 2;
        int op2 = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3366.minArraySum(nums, k, op1, op2));
    }
}