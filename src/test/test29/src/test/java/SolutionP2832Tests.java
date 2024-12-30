import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2832Tests {
    private final SolutionP2832 solutionP2832 = new SolutionP2832();

    @Test
    public void example1() {
        int[] nums = {1, 5, 4, 3, 6};
        int[] expected = {1, 4, 2, 1, 5};
        Assertions.assertArrayEquals(expected, solutionP2832.maximumLengthOfRanges(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, solutionP2832.maximumLengthOfRanges(nums));
    }
}