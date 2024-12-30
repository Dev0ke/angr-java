import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2344Tests {
    private final Solution2344 solution2344 = new Solution2344();

    @Test
    public void example1() {
        int[] nums = {2, 3, 2, 4, 3};
        int[] numsDivide = {9, 6, 9, 3, 15};
        int expected = 2;
        Assertions.assertEquals(expected, solution2344.minOperations(nums, numsDivide));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 6};
        int[] numsDivide = {8, 2, 6, 10};
        int expected = -1;
        Assertions.assertEquals(expected, solution2344.minOperations(nums, numsDivide));
    }
}
