import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1966Tests {
    private final SolutionP1966 solutionP1966 = new SolutionP1966();

    @Test
    public void example1() {
        int[] nums = {7};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1966.binarySearchableNumbers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 5, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1966.binarySearchableNumbers(nums));
    }
}