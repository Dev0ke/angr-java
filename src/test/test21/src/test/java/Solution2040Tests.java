import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2040Tests {
    private final Solution2040 solution2040 = new Solution2040();

    @Test
    public void example1() {
        int[] nums1 = {2, 5};
        int[] nums2 = {3, 4};
        long k = 2;
        long expected = 8;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct2(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {-4, -2, 0, 3};
        int[] nums2 = {2, 4};
        long k = 6;
        long expected = 0;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct2(nums1, nums2, k));
    }

    @Test
    public void example3() {
        int[] nums1 = {-2, -1, 0, 1, 2};
        int[] nums2 = {-3, -1, 2, 4, 5};
        long k = 3;
        long expected = -6;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct2(nums1, nums2, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/229507058/
        // 79 / 112 个通过测试用例
        String fileName = "solution2040-example4-input.txt";
        int[] nums1 = UtUtils.loadingInts(fileName, 0);
        int[] nums2 = UtUtils.loadingInts(fileName, 1);
        long k = UtUtils.loadingLong(fileName, 2);
        long expected = 152240;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/229516650/
        // 80 / 112 个通过测试用例
        String fileName = "solution2040-example5-input.txt";
        int[] nums1 = UtUtils.loadingInts(fileName, 0);
        int[] nums2 = UtUtils.loadingInts(fileName, 1);
        long k = UtUtils.loadingLong(fileName, 2);
        long expected = -509675;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/submissions/detail/229518916/
        // 82 / 112 个通过测试用例
        String fileName = "solution2040-example6-input.txt";
        int[] nums1 = UtUtils.loadingInts(fileName, 0);
        int[] nums2 = UtUtils.loadingInts(fileName, 1);
        long k = UtUtils.loadingLong(fileName, 2);
        long expected = 28107;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
    }

    @Test
    public void example7() {
        // https://leetcode.cn/submissions/detail/229519451/
        // 83 / 112 个通过测试用例
        String fileName = "solution2040-example7-input.txt";
        int[] nums1 = UtUtils.loadingInts(fileName, 0);
        int[] nums2 = UtUtils.loadingInts(fileName, 1);
        long k = UtUtils.loadingLong(fileName, 2);
        long expected = -368970;
        Assertions.assertEquals(expected, solution2040.kthSmallestProduct(nums1, nums2, k));
    }
}
