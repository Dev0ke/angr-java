import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1681Tests {
    private final Solution1681 solution1681 = new Solution1681();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 4};
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1681.minimumIncompatibility(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3, 8, 1, 3, 1, 2, 2};
        int k = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution1681.minimumIncompatibility(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 3, 3, 6, 3, 3};
        int k = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution1681.minimumIncompatibility(nums, k));
    }
}
