import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP548Tests {
    private final SolutionP548 solutionP548 = new SolutionP548();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1};
        Assertions.assertTrue(solutionP548.splitArray(nums));
        Assertions.assertTrue(solutionP548.splitArray2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
        Assertions.assertFalse(solutionP548.splitArray(nums));
        Assertions.assertFalse(solutionP548.splitArray2(nums));
    }
}
