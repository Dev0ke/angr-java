import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3048Tests {
    private final Solution3048 solution3048 = new Solution3048();

    @Test
    public void example1() {
        int[] nums = {2, 2, 0};
        int[] changeIndices = {2, 2, 2, 2, 3, 2, 2, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solution3048.earliestSecondToMarkIndices(nums, changeIndices));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3};
        int[] changeIndices = {1, 1, 1, 2, 1, 1, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution3048.earliestSecondToMarkIndices(nums, changeIndices));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1};
        int[] changeIndices = {2, 2, 2};
        int expected = -1;
        Assertions.assertEquals(expected, solution3048.earliestSecondToMarkIndices(nums, changeIndices));
    }
}