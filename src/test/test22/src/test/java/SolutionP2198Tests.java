import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2198Tests {
    private final SolutionP2198 solutionP2198 = new SolutionP2198();

    @Test
    public void example1() {
        int[] nums = {4, 6, 7, 3, 2};
        long expected = 12;
        Assertions.assertEquals(expected, solutionP2198.singleDivisorTriplet(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2};
        long expected = 6;
        Assertions.assertEquals(expected, solutionP2198.singleDivisorTriplet(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2198.singleDivisorTriplet(nums));
    }
}