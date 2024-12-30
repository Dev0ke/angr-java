import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2570Tests {
    private final Solution2570 solution2570 = new Solution2570();

    @Test
    public void example1() {
        int[][] nums1 = UtUtils.stringToInts2("[[1,2],[2,3],[4,5]]");
        int[][] nums2 = UtUtils.stringToInts2("[[1,4],[3,2],[4,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,6],[2,3],[3,2],[4,6]]");
        Assertions.assertArrayEquals(expected, solution2570.mergeArrays(nums1, nums2));
    }

    @Test
    public void example2() {
        int[][] nums1 = UtUtils.stringToInts2("[[2,4],[3,6],[5,5]]");
        int[][] nums2 = UtUtils.stringToInts2("[[1,3],[4,3]]");
        int[][] expected = UtUtils.stringToInts2("[[1,3],[2,4],[3,6],[4,3],[5,5]]");
        Assertions.assertArrayEquals(expected, solution2570.mergeArrays(nums1, nums2));
    }
}