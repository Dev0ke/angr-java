import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution327Tests {
    private final Solution327 solution327 = new Solution327();

    @Test
    public void example1() {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution327.countRangeSum(nums, lower, upper));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int lower = 0;
        int upper = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution327.countRangeSum(nums, lower, upper));
    }
}