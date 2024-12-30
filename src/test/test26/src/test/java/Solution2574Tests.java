import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2574Tests {
    private final Solution2574 solution2574 = new Solution2574();

    @Test
    public void example1() {
        int[] nums = {10, 4, 8, 3};
        int[] expected = {15, 1, 11, 22};
        Assertions.assertArrayEquals(expected, solution2574.leftRigthDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution2574.leftRigthDifference(nums));
    }
}