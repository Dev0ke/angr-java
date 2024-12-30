import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2191Tests {
    private final Solution2191 solution2191 = new Solution2191();

    @Test
    public void example1() {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        int[] expected = {338, 38, 991};
        Assertions.assertArrayEquals(expected, solution2191.sortJumbled(mapping, nums));
    }

    @Test
    public void example2() {
        int[] mapping = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {789, 456, 123};
        int[] expected = {123, 456, 789};
        Assertions.assertArrayEquals(expected, solution2191.sortJumbled(mapping, nums));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] mapping = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Assertions.assertArrayEquals(expected, solution2191.sortJumbled(mapping, nums));
    }
}
