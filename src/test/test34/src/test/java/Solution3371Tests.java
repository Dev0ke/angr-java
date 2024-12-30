import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3371Tests {
    private final Solution3371 solution3371 = new Solution3371();

    @Test
    public void example1() {
        int[] nums = {2, 3, 5, 10};
        int expected = 10;
        Assertions.assertEquals(expected, solution3371.getLargestOutlier(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-2, -1, -3, -6, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution3371.getLargestOutlier(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1, 5, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution3371.getLargestOutlier(nums));
    }
}