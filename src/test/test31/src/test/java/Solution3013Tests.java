import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3013Tests {
    private final Solution3013 solution3013 = new Solution3013();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 6, 4, 2};
        int k = 3;
        int dist = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solution3013.minimumCost(nums, k, dist));
    }

    @Test
    public void example2() {
        int[] nums = {10, 1, 2, 2, 2, 1};
        int k = 4;
        int dist = 3;
        long expected = 15;
        Assertions.assertEquals(expected, solution3013.minimumCost(nums, k, dist));
    }

    @Test
    public void example3() {
        int[] nums = {10, 8, 18, 9};
        int k = 3;
        int dist = 1;
        long expected = 36;
        Assertions.assertEquals(expected, solution3013.minimumCost(nums, k, dist));
    }
}