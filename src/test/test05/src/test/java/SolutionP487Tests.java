import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP487Tests {
    private final SolutionP487 solutionP487 = new SolutionP487();

    @Test
    public void example1() {
        int[] nums = {1, 0, 1, 1, 0};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP487.findMaxConsecutiveOnes(nums));
    }
}
