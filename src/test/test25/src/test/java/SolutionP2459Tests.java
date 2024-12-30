import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2459Tests {
    private final SolutionP2459 solutionP2459 = new SolutionP2459();

    @Test
    public void example1() {
        int[] nums = {4, 2, 0, 3, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2459.sortArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2459.sortArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 0, 2, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2459.sortArray(nums));
    }
}