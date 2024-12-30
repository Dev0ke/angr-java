import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2263Tests {
    private final SolutionP2263 solutionP2263 = new SolutionP2263();

    @Test
    public void example1() {
        int[] nums = {3, 2, 4, 5, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2263.convertArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2263.convertArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2263.convertArray(nums));
    }
}