import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution198Tests {
    private final Solution198 solution198 = new Solution198();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution198.rob(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 7, 9, 3, 1};
        int expected = 12;
        Assertions.assertEquals(expected, solution198.rob(nums));
    }
}
