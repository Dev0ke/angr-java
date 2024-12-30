import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3049Tests {
    private final Solution3049 solution3049 = new Solution3049();

    @Test
    public void example1() {
        int[] nums = {3, 2, 3};
        int[] changeIndices = {1, 3, 2, 2, 2, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution3049.earliestSecondToMarkIndices(nums, changeIndices));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 1, 2};
        int[] changeIndices = {1, 2, 1, 2, 1, 2, 1, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution3049.earliestSecondToMarkIndices(nums, changeIndices));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int[] changeIndices = {1, 2, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution3049.earliestSecondToMarkIndices(nums, changeIndices));
    }
}