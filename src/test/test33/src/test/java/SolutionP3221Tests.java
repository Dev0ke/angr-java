import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3221Tests {
    private final SolutionP3221 solutionP3221 = new SolutionP3221();

    @Test
    public void example1() {
        int[] nums = {1, 5, 8};
        long expected = 16;
        Assertions.assertEquals(expected, solutionP3221.maxScore(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 2, 8, 9, 1, 3};
        long expected = 42;
        Assertions.assertEquals(expected, solutionP3221.maxScore(nums));
    }
}