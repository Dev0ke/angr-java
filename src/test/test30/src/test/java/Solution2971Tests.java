import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2971Tests {
    private final Solution2971 solution2971 = new Solution2971();

    @Test
    public void example1() {
        int[] nums = {5, 5, 5};
        long expected = 15;
        Assertions.assertEquals(expected, solution2971.largestPerimeter(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        long expected = 12;
        Assertions.assertEquals(expected, solution2971.largestPerimeter(nums));
    }

    @Test
    public void exampl3() {
        int[] nums = {5, 5, 50};
        long expected = -1;
        Assertions.assertEquals(expected, solution2971.largestPerimeter(nums));
    }
}