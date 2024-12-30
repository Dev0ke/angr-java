import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2342Tests {
    private final Solution2342 solution2342 = new Solution2342();

    @Test
    public void example1() {
        int[] nums = {18, 43, 36, 13, 7};
        int expected = 54;
        Assertions.assertEquals(expected, solution2342.maximumSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 12, 19, 14};
        int expected = -1;
        Assertions.assertEquals(expected, solution2342.maximumSum(nums));
    }
}
