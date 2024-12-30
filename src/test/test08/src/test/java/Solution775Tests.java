import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution775Tests {
    private final Solution775 solution775 = new Solution775();

    @Test
    public void example1() {
        int[] nums = {1, 0, 2};
        Assertions.assertTrue(solution775.isIdealPermutation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 0};
        Assertions.assertFalse(solution775.isIdealPermutation(nums));
    }
}