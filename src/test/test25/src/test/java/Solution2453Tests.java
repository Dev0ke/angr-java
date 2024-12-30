import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2453Tests {
    private final Solution2453 solution2453 = new Solution2453();

    @Test
    public void example1() {
        int[] nums = {3, 7, 8, 1, 1, 5};
        int space = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2453.destroyTargets(nums, space));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 5, 2, 4, 6};
        int space = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2453.destroyTargets(nums, space));
    }

    @Test
    public void example3() {
        int[] nums = {6, 2, 5};
        int space = 100;
        int expected = 2;
        Assertions.assertEquals(expected, solution2453.destroyTargets(nums, space));
    }
}
