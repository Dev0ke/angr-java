import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1685Tests {
    private final Solution1685 solution1685 = new Solution1685();

    @Test
    public void example1() {
        int[] nums = {2, 3, 5};
        int[] expected = {4, 3, 5};
        Assertions.assertArrayEquals(expected, solution1685.getSumAbsoluteDifferences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 6, 8, 10};
        int[] expected = {24, 15, 13, 15, 21};
        Assertions.assertArrayEquals(expected, solution1685.getSumAbsoluteDifferences(nums));
    }
}