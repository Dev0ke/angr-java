import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3269Tests {
    private final SolutionP3269 solutionP3269 = new SolutionP3269();

    @Test
    public void example1() {
        int[] nums1 = {};
        int[] nums2 = {1, 0, 1, 1};
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3269.minLargest(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 1, 0, 1};
        int[] nums2 = {1, 0, 0, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solutionP3269.minLargest(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {0, 1, 0, 0, 1};
        int[] nums2 = {0, 0, 0, 1};
        int expected = 13;
        Assertions.assertEquals(expected, solutionP3269.minLargest(nums1, nums2));
    }
}