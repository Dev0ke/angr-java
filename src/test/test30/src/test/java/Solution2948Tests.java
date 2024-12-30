import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2948Tests {
    private final Solution2948 solution2948 = new Solution2948();

    @Test
    public void example1() {
        int[] nums = {1, 5, 3, 9, 8};
        int limit = 2;
        int[] expected = {1, 3, 5, 8, 9};
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray(nums, limit));
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray2(nums, limit));
    }

    @Test
    public void example2() {
        int[] nums = {1, 7, 6, 18, 2, 1};
        int limit = 3;
        int[] expected = {1, 6, 7, 18, 1, 2};
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray(nums, limit));
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray2(nums, limit));
    }

    @Test
    public void example3() {
        int[] nums = {1, 7, 28, 19, 10};
        int limit = 3;
        int[] expected = {1, 7, 28, 19, 10};
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray(nums, limit));
        Assertions.assertArrayEquals(expected, solution2948.lexicographicallySmallestArray2(nums, limit));
    }
}