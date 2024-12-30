import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1885Tests {
    private final SolutionP1885 solutionP1885 = new SolutionP1885();

    @Test
    public void example1() {
        int[] nums1 = {2, 1, 2, 1};
        int[] nums2 = {1, 2, 1, 2};
        long expected = 1;
        Assertions.assertEquals(expected, solutionP1885.countPairs(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 10, 6, 2};
        int[] nums2 = {1, 4, 1, 5};
        long expected = 5;
        Assertions.assertEquals(expected, solutionP1885.countPairs(nums1, nums2));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/321420715/
        // 38 / 45 个通过测试用例 TLE
        int[] nums1 = UtUtils.loadingInts("solution1885-example3-input.txt", 0);
        int[] nums2 = UtUtils.loadingInts("solution1885-example3-input.txt", 1);
        long expected = 469169690;
        Assertions.assertEquals(expected, solutionP1885.countPairs(nums1, nums2));
    }
}
