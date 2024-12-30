import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution209Tests {
    private final Solution209 solution209 = new Solution209();

    @Test
    public void example1() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution209.minSubArrayLen(target, nums));
    }

    @Test
    public void example2() {
        int target = 4;
        int[] nums = {1, 4, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution209.minSubArrayLen(target, nums));
    }

    @Test
    public void example3() {
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution209.minSubArrayLen(target, nums));
    }
}
