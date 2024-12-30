import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3092Tests {
    private final Solution3092 solution3092 = new Solution3092();

    @Test
    public void example1() {
        int[] nums = {2, 3, 2, 1};
        int[] freq = {3, 2, -3, 1};
        long[] expected = {3, 3, 2, 2};
        Assertions.assertArrayEquals(expected, solution3092.mostFrequentIDs(nums, freq));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 3};
        int[] freq = {2, -2, 1};
        long[] expected = {2, 0, 1};
        Assertions.assertArrayEquals(expected, solution3092.mostFrequentIDs(nums, freq));
    }
}