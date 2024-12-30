import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2164Tests {
    private final Solution2164 solution2164 = new Solution2164();

    @Test
    public void example1() {
        int[] nums = {4, 1, 2, 3};
        int[] expected = {2, 3, 4, 1};
        Assertions.assertArrayEquals(expected, solution2164.sortEvenOdd(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1};
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution2164.sortEvenOdd(nums));
    }
}
