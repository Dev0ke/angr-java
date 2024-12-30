import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3117Tests {
    private final Solution3117 solution3117 = new Solution3117();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 3, 2};
        int[] andValues = {0, 3, 3, 2};
        int expected = 12;
        Assertions.assertEquals(expected, solution3117.minimumValueSum(nums, andValues));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 5, 7, 7, 7, 5};
        int[] andValues = {0, 7, 5};
        int expected = 17;
        Assertions.assertEquals(expected, solution3117.minimumValueSum(nums, andValues));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int[] andValues = {2};
        int expected = -1;
        Assertions.assertEquals(expected, solution3117.minimumValueSum(nums, andValues));
    }
}