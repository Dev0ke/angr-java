import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2542Tests {
    private final Solution2542 solution2542 = new Solution2542();

    @Test
    public void example1() {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        long expected = 12;
        Assertions.assertEquals(expected, solution2542.maxScore(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {4, 2, 3, 1, 1};
        int[] nums2 = {7, 5, 10, 9, 6};
        int k = 1;
        long expected = 30;
        Assertions.assertEquals(expected, solution2542.maxScore(nums1, nums2, k));
    }
}