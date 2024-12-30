import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3205Tests {
    private final SolutionP3205 solutionP3205 = new SolutionP3205();

    @Test
    public void example1() {
        int[] nums = {1, 5, 8};
        int expected = 16;
        Assertions.assertEquals(expected, solutionP3205.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 2, 8, 9, 1, 3};
        int expected = 42;
        Assertions.assertEquals(expected, solutionP3205.maxScore(nums));
    }
}