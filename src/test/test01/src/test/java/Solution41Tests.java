import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution41Tests {
    private final Solution41 solution41 = new Solution41();

    @Test
    public void example1() {
        int[] nums = {1, 2, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution41.firstMissingPositive(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, -1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution41.firstMissingPositive(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 8, 9, 11, 12};
        int expected = 1;
        Assertions.assertEquals(expected, solution41.firstMissingPositive(nums));
    }
}
