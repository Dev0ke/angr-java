import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution213Tests {
    private final Solution213 solution213 = new Solution213();

    @Test
    public void example1() {
        int[] nums = {2, 3, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution213.rob(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution213.rob(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution213.rob(nums));
    }
}
