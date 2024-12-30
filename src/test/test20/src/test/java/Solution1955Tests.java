import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1955Tests {
    private final Solution1955 solution1955 = new Solution1955();

    @Test
    public void example1() {
        int[] nums = {0, 1, 2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution1955.countSpecialSubsequences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 0, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1955.countSpecialSubsequences(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1, 2, 0, 1, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution1955.countSpecialSubsequences(nums));
    }
}
