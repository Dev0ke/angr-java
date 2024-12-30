import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3277Tests {
    private final Solution3277 solution3277 = new Solution3277();

    @Test
    public void example1() {
        int[] nums = {2, 8, 4, 32, 16, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[1,4],[0,5]]");
        int[] expected = {12, 60, 60};
        Assertions.assertArrayEquals(expected, solution3277.maximumSubarrayXor(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {0, 7, 3, 2, 8, 5, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,3],[1,5],[2,4],[2,6],[5,6]]");
        int[] expected = {7, 14, 11, 14, 5};
        Assertions.assertArrayEquals(expected, solution3277.maximumSubarrayXor(nums, queries));
    }
}