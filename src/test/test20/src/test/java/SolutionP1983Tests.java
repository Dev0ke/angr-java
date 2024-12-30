import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1983Tests {
    private final SolutionP1983 solutionP1983 = new SolutionP1983();

    @Test
    public void example1() {
        int[] nums1 = {1, 1, 0, 1};
        int[] nums2 = {0, 1, 1, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1983.widestPairOfIndices(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 1};
        int[] nums2 = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1983.widestPairOfIndices(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1983.widestPairOfIndices(nums1, nums2));
    }
}