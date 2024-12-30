import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1991Tests {
    private final Solution1991 solution1991 = new Solution1991();

    @Test
    public void example1() {
        int[] nums = {2, 3, -1, 8, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution1991.findMiddleIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, -1, 4};
        int expected = 2;
        Assertions.assertEquals(expected, solution1991.findMiddleIndex(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solution1991.findMiddleIndex(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1991.findMiddleIndex(nums));
    }
}
