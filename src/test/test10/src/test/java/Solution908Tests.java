import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution908Tests {
    private final Solution908 solution908 = new Solution908();

    @Test
    public void example1() {
        int[] nums = {1};
        int k = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution908.smallestRangeI(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 10};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution908.smallestRangeI(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 6};
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution908.smallestRangeI(nums, k));
    }
}
