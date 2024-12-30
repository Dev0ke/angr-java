import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2974Tests {
    private final Solution2974 solution2974 = new Solution2974();

    @Test
    public void example1() {
        int[] nums = {5, 4, 2, 3};
        int[] expected = {3, 2, 5, 4};
        Assertions.assertArrayEquals(expected, solution2974.numberGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 5};
        int[] expected = {5, 2};
        Assertions.assertArrayEquals(expected, solution2974.numberGame(nums));
    }
}