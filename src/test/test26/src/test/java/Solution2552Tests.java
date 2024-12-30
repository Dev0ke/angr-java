import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2552Tests {
    private final Solution2552 solution2552 = new Solution2552();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution2552.countQuadruplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution2552.countQuadruplets(nums));
    }
}