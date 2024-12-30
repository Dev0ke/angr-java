import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2436Tests {
    private final SolutionP2436 solutionP2436 = new SolutionP2436();

    @Test
    public void example1() {
        int[] nums = {12, 6, 3, 14, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2436.minimumSplits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 12, 6, 14};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2436.minimumSplits(nums));
    }
}