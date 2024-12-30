import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1636Tests {
    private final Solution1636 solution1636 = new Solution1636();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] expected = {3, 1, 1, 2, 2, 2};
        Assertions.assertArrayEquals(expected, solution1636.frequencySort(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1, 3, 2};
        int[] expected = {1, 3, 3, 2, 2};
        Assertions.assertArrayEquals(expected, solution1636.frequencySort(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        int[] expected = {5, -1, 4, 4, -6, -6, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution1636.frequencySort(nums));
    }
}
