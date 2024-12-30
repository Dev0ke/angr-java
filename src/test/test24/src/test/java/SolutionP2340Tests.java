import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2340Tests {
    private final SolutionP2340 solutionP2340 = new SolutionP2340();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 5, 3, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2340.minimumSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2340.minimumSwaps(nums));
    }
}