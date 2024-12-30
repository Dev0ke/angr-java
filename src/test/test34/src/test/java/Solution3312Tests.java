import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3312Tests {
    private final Solution3312 solution3312 = new Solution3312();

    @Test
    public void example1() {
        int[] nums = {2, 3, 4};
        long[] queries = {0, 2, 2};
        int[] expected = {1, 2, 2};
        Assertions.assertArrayEquals(expected, solution3312.gcdValues(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 2, 1};
        long[] queries = {5, 3, 1, 0};
        int[] expected = {4, 2, 1, 1};
        Assertions.assertArrayEquals(expected, solution3312.gcdValues(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2};
        long[] queries = {0, 0};
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution3312.gcdValues(nums, queries));
    }
}