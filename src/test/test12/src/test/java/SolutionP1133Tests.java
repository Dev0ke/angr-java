import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1133Tests {
    private final SolutionP1133 solutionP1133 = new SolutionP1133();

    @Test
    public void example1() {
        int[] nums = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        int expected = 8;
        Assertions.assertEquals(expected, solutionP1133.largestUniqueNumber(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 9, 8, 8};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1133.largestUniqueNumber(nums));
    }
}
