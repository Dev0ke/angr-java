import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1995Tests {
    private final Solution1995 solution1995 = new Solution1995();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solution1995.countQuadruplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 6, 4, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1995.countQuadruplets(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 3, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution1995.countQuadruplets(nums));
    }
}
