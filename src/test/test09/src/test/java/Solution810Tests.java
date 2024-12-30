import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution810Tests {
    private final Solution810 solution810 = new Solution810();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2};
        Assertions.assertFalse(solution810.xorGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1};
        Assertions.assertTrue(solution810.xorGame(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        Assertions.assertTrue(solution810.xorGame(nums));
    }
}