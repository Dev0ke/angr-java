import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2143Tests {
    private final SolutionP2143 solutionP2143 = new SolutionP2143();

    @Test
    public void example1() {
        int[] nums1 = {1, 2, 5};
        int[] nums2 = {2, 6, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2143.countSubranges(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 1};
        int[] nums2 = {1, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2143.countSubranges(nums1, nums2));
    }
}