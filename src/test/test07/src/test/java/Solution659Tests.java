import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution659Tests {
    private final Solution659 solution659 = new Solution659();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 3, 4, 5};
        Assertions.assertTrue(solution659.isPossible(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 5};
        Assertions.assertTrue(solution659.isPossible(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 4, 5};
        Assertions.assertFalse(solution659.isPossible(nums));
    }
}