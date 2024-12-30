import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3346Tests {
    private final Solution3346 solution3346 = new Solution3346();

    @Test
    public void example1() {
        int[] nums = {1, 4, 5};
        int k = 1;
        int numOperations = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3346.maxFrequency(nums, k, numOperations));
    }

    @Test
    public void example2() {
        int[] nums = {5, 11, 20, 20};
        int k = 5;
        int numOperations = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3346.maxFrequency(nums, k, numOperations));
    }
}