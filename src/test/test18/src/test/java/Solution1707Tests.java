import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1707Tests {
    private final Solution1707 solution1707 = new Solution1707();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] queries = UtUtils.stringToInts2("[[3,1],[1,3],[5,6]]");
        int[] expected = {3, 3, 7};
        Assertions.assertArrayEquals(expected, solution1707.maximizeXor(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = UtUtils.stringToInts2("[[12,4],[8,1],[6,3]]");
        int[] expected = {15, -1, 5};
        Assertions.assertArrayEquals(expected, solution1707.maximizeXor(nums, queries));
    }
}