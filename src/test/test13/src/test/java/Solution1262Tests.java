import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1262Tests {
    private final Solution1262 solution1262 = new Solution1262();

    @Test
    public void example1() {
        int[] nums = {3, 6, 5, 1, 8};
        int expected = 18;
        Assertions.assertEquals(expected, solution1262.maxSumDivThree(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4};
        int expected = 0;
        Assertions.assertEquals(expected, solution1262.maxSumDivThree(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solution1262.maxSumDivThree(nums));
    }
}