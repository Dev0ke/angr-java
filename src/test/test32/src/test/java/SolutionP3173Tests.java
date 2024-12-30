import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3173Tests {
    private final SolutionP3173 solutionP3173 = new SolutionP3173();

    @Test
    public void example1() {
        int[] nums = {1, 3, 7, 15};
        int[] expected = {3, 7, 15};
        Assertions.assertArrayEquals(expected, solutionP3173.orArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {8, 4, 2};
        int[] expected = {12, 6};
        Assertions.assertArrayEquals(expected, solutionP3173.orArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 4, 9, 11};
        int[] expected = {5, 13, 11};
        Assertions.assertArrayEquals(expected, solutionP3173.orArray(nums));
    }
}