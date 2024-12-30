import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP760Tests {
    private final SolutionP760 solutionP760 = new SolutionP760();

    @Test
    public void example1() {
        int[] nums1 = {12, 28, 46, 32, 50};
        int[] nums2 = {50, 12, 32, 46, 28};
        int[] expected = {1, 4, 3, 2, 0};
        Assertions.assertArrayEquals(expected, solutionP760.anagramMappings(nums1, nums2));
    }
}