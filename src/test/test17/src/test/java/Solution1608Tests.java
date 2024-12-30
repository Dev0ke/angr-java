import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1608Tests {
    private final Solution1608 solution1608 = new Solution1608();

    @Test
    public void example1() {
        int[] nums = {3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution1608.specialArray(nums));
        Assertions.assertEquals(expected, solution1608.specialArray2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution1608.specialArray(nums));
        Assertions.assertEquals(expected, solution1608.specialArray2(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 4, 3, 0, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution1608.specialArray(nums));
        Assertions.assertEquals(expected, solution1608.specialArray2(nums));
    }

    @Test
    public void example4() {
        int[] nums = {3, 6, 7, 7, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution1608.specialArray(nums));
        Assertions.assertEquals(expected, solution1608.specialArray2(nums));
    }
}
