import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3069Tests {
    private final Solution3069 solution3069 = new Solution3069();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solution3069.resultArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 3, 8};
        int[] expected = {5, 3, 4, 8};
        Assertions.assertArrayEquals(expected, solution3069.resultArray(nums));
    }
}