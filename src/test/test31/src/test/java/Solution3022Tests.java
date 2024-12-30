import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3022Tests {
    private final Solution3022 solution3022 = new Solution3022();

    @Test
    public void example1() {
        int[] nums = {3, 5, 3, 2, 7};
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3022.minOrAfterOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {7, 3, 15, 14, 2, 8};
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3022.minOrAfterOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {10, 7, 10, 3, 9, 14, 9, 4};
        int k = 1;
        int expected = 15;
        Assertions.assertEquals(expected, solution3022.minOrAfterOperations(nums, k));
    }
}