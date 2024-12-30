import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2613Tests {
    private final SolutionP2613 solutionP2613 = new SolutionP2613();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 3, 2, 4};
        int[] nums2 = {2, 3, 1, 2, 3};
        int[] expected = {0, 3};
        Assertions.assertArrayEquals(expected, solutionP2613.beautifulPair(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 4, 3, 2, 5};
        int[] nums2 = {1, 4, 2, 3, 5, 1};
        int[] expected = {1, 4};
        Assertions.assertArrayEquals(expected, solutionP2613.beautifulPair(nums1, nums2));
    }
}