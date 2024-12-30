import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3080Tests {
    private final Solution3080 solution3080 = new Solution3080();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1, 2, 3, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,2],[3,3],[4,2]]");
        long[] expected = {8, 3, 0};
        Assertions.assertArrayEquals(expected, solution3080.unmarkedSumArray(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 3};
        int[][] queries = UtUtils.stringToInts2("[[0,1]]");
        long[] expected = {7};
        Assertions.assertArrayEquals(expected, solution3080.unmarkedSumArray(nums, queries));
    }
}