import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1929Tests {
    private final Solution1929 solution1929 = new Solution1929();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int[] expected = {1, 2, 1, 1, 2, 1};
        Assertions.assertArrayEquals(expected, solution1929.getConcatenation(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 2, 1};
        int[] expected = {1, 3, 2, 1, 1, 3, 2, 1};
        Assertions.assertArrayEquals(expected, solution1929.getConcatenation(nums));
    }
}
