import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2206Tests {
    private final Solution2206 solution2206 = new Solution2206();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3, 2, 2, 2};
        Assertions.assertTrue(solution2206.divideArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertFalse(solution2206.divideArray(nums));
    }
}
