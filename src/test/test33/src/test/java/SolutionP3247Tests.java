import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3247Tests {
    private final SolutionP3247 solutionP3247 = new SolutionP3247();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3247.subsequenceCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3247.subsequenceCount(nums));
    }
}