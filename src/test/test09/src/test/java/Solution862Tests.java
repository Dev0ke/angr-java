import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution862Tests {
    private final Solution862 solution862 = new Solution862();

    @Test
    public void example1() {
        int[] nums = {1};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution862.shortestSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int k = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution862.shortestSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {2, -1, 2};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution862.shortestSubarray(nums, k));
    }
}
