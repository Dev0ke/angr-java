import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution128Tests {
    private final Solution128 solution128 = new Solution128();

    @Test
    public void example1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution128.longestConsecutive(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected = 9;
        Assertions.assertEquals(expected, solution128.longestConsecutive(nums));
    }
}
