import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1144Tests {
    private final Solution1144 solution1144 = new Solution1144();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution1144.movesToMakeZigzag(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 6, 1, 6, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution1144.movesToMakeZigzag(nums));
    }
}