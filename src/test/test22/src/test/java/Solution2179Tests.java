import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2179Tests {
    private final Solution2179 solution2179 = new Solution2179();

    @Test
    public void example1() {
        int[] nums1 = {2, 0, 1, 3};
        int[] nums2 = {0, 1, 2, 3};
        long expected = 1;
        Assertions.assertEquals(expected, solution2179.goodTriplets(nums1, nums2));
        Assertions.assertEquals(expected, solution2179.goodTriplets2(nums1, nums2));
        Assertions.assertEquals(expected, solution2179.goodTriplets3(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {4, 0, 1, 3, 2};
        int[] nums2 = {4, 1, 0, 2, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution2179.goodTriplets(nums1, nums2));
        Assertions.assertEquals(expected, solution2179.goodTriplets2(nums1, nums2));
        Assertions.assertEquals(expected, solution2179.goodTriplets3(nums1, nums2));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums1 = UtUtils.loadingInts("solution2179-example3-input.txt", 0);
        int[] nums2 = UtUtils.loadingInts("solution2179-example3-input.txt", 1);
        long expected = 27752300496112L;
        Assertions.assertEquals(expected, solution2179.goodTriplets(nums1, nums2));
    }

    @Test
    public void example4() {
        int[] nums1 = {13, 14, 10, 2, 12, 3, 9, 11, 15, 8, 4, 7, 0, 6, 5, 1};
        int[] nums2 = {8, 7, 9, 5, 6, 14, 15, 10, 2, 11, 4, 13, 3, 12, 1, 0};
        int expected = 77;
        Assertions.assertEquals(expected, solution2179.goodTriplets(nums1, nums2));
    }
}