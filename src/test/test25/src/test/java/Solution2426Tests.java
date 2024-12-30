import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2426Tests {
    private final Solution2426.V1 solution2426_v1 = new Solution2426.V1();
    private final Solution2426.V2 solution2426_v2 = new Solution2426.V2();

    @Test
    public void example1() {
        int[] nums1 = {3, 2, 5};
        int[] nums2 = {2, 2, 1};
        int diff = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution2426_v1.numberOfPairs(nums1, nums2, diff));
        Assertions.assertEquals(expected, solution2426_v2.numberOfPairs(nums1, nums2, diff));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, -1};
        int[] nums2 = {-2, 2};
        int diff = -1;
        long expected = 0;
        Assertions.assertEquals(expected, solution2426_v1.numberOfPairs(nums1, nums2, diff));
        Assertions.assertEquals(expected, solution2426_v2.numberOfPairs(nums1, nums2, diff));
    }
}
