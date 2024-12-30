import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2717Tests {
    private final Solution2717 solution2717 = new Solution2717();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution2717.semiOrderedPermutation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2717.semiOrderedPermutation(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 4, 2, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solution2717.semiOrderedPermutation(nums));
    }
}