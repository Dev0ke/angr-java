import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution16Tests {
    private final Solution16 solution16 = new Solution16();

    @Test
    public void example1() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution16.threeSumClosest(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        int target = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution16.threeSumClosest(nums, target));
    }
}
