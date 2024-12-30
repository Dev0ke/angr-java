import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3224Tests {
    private final Solution3224 solution3224 = new Solution3224();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1, 2, 4, 3};
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3224.minChanges(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 2, 3, 3, 6, 5, 4};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3224.minChanges(nums, k));
    }
}