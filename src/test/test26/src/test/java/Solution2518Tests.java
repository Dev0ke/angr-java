import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2518Tests {
    private final Solution2518 solution2518 = new Solution2518();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int k = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution2518.countPartitions(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3};
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution2518.countPartitions(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {6, 6};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2518.countPartitions(nums, k));
    }
}
