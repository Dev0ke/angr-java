import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2293Tests {
    private final Solution2293 solution2293 = new Solution2293();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 2, 4, 8, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution2293.minMaxGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2293.minMaxGame(nums));
    }
}
