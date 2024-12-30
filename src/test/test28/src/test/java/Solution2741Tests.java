import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2741Tests {
    private final Solution2741 solution2741 = new Solution2741();

    @Test
    public void example1() {
        int[] nums = {2, 3, 6};
        int expected = 2;
        Assertions.assertEquals(expected, solution2741.specialPerm(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2741.specialPerm(nums));
    }
}