import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2221Tests {
    private final Solution2221 solution2221 = new Solution2221();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution2221.triangularSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5};
        int expected = 5;
        Assertions.assertEquals(expected, solution2221.triangularSum(nums));
    }
}
