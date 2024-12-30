import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2569Tests {
    private final Solution2569 solution2569 = new Solution2569();

    @Test
    public void example1() {
        int[] nums1 = {1, 0, 1};
        int[] nums2 = {0, 0, 0};
        int[][] queries = UtUtils.stringToInts2("[[1,1,1],[2,1,0],[3,0,0]]");
        long[] expected = {3};
        Assertions.assertArrayEquals(expected, solution2569.handleQuery(nums1, nums2, queries));
    }

    @Test
    public void example2() {
        int[] nums1 = {1};
        int[] nums2 = {5};
        int[][] queries = UtUtils.stringToInts2("[[2,0,0],[3,0,0]]");
        long[] expected = {5};
        Assertions.assertArrayEquals(expected, solution2569.handleQuery(nums1, nums2, queries));
    }
}