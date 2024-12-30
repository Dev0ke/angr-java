import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2601Tests {
    private final Solution2601 solution2601 = new Solution2601();

    @Test
    public void example1() {
        int[] nums = {4, 9, 6, 10};
        Assertions.assertTrue(solution2601.primeSubOperation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 8, 11, 12};
        Assertions.assertTrue(solution2601.primeSubOperation(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 8, 3};
        Assertions.assertFalse(solution2601.primeSubOperation(nums));
    }
}