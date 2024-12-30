import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution239Tests {
    private final Solution239.V1 solution239_v1 = new Solution239.V1();
    private final Solution239.V2 solution239_v2 = new Solution239.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solution239_v1.maxSlidingWindow(nums, k));
        Assertions.assertArrayEquals(expected, solution239_v2.maxSlidingWindow(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution239_v1.maxSlidingWindow(nums, k));
        Assertions.assertArrayEquals(expected, solution239_v2.maxSlidingWindow(nums, k));
    }
}
