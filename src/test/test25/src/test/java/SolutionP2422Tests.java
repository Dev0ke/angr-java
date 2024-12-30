import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2422Tests {
    private final SolutionP2422 solutionP2422 = new SolutionP2422();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 1, 2, 3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2422.minimumOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2422.minimumOperations(nums));
    }
}