import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1874Tests {
    private final SolutionP1874 solutionP1874 = new SolutionP1874();

    @Test
    public void example1() {
        int[] nums1 = {5, 3, 4, 2};
        int[] nums2 = {4, 2, 2, 5};
        int expected = 40;
        Assertions.assertEquals(expected, solutionP1874.minProductSum(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 1, 4, 5, 7};
        int[] nums2 = {3, 2, 4, 8, 6};
        int expected = 65;
        Assertions.assertEquals(expected, solutionP1874.minProductSum(nums1, nums2));
    }
}