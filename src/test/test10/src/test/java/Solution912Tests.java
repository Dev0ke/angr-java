import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution912Tests {
    private final Solution912 solution912 = new Solution912();

    @Test
    public void example1() {
        int[] nums = {5, 2, 3, 1};
        int[] expected = {1, 2, 3, 5};
        Assertions.assertArrayEquals(expected, solution912.sortArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] expected = {0, 0, 1, 1, 2, 5};
        Assertions.assertArrayEquals(expected, solution912.sortArray(nums));
    }
}
