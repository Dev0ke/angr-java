import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1911Tests {
    private final Solution1911 solution1911 = new Solution1911();

    @Test
    public void example1() {
        int[] nums = {4, 2, 5, 3};
        long expected = 7;
        Assertions.assertEquals(expected, solution1911.maxAlternatingSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 7, 8};
        long expected = 8;
        Assertions.assertEquals(expected, solution1911.maxAlternatingSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {6, 2, 1, 2, 4, 5};
        long expected = 10;
        Assertions.assertEquals(expected, solution1911.maxAlternatingSum(nums));
    }
}