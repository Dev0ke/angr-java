import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution977Tests {
    private final Solution977 solution977 = new Solution977();

    @Test
    public void example1() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        Assertions.assertArrayEquals(expected, solution977.sortedSquares(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] expected = {4, 9, 9, 49, 121};
        Assertions.assertArrayEquals(expected, solution977.sortedSquares(nums));
    }
}
