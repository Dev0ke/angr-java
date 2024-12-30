import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1085Tests {
    private final SolutionP1085 solutionP1085 = new SolutionP1085();

    @Test
    public void example1() {
        int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP1085.sumOfDigits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {99, 77, 33, 66, 55};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP1085.sumOfDigits(nums));
    }
}
