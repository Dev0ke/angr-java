import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2495Tests {
    private final SolutionP2495 solutionP2495 = new SolutionP2495();

    @Test
    public void example1() {
        int[] nums = {9, 6, 7, 13};
        long expected = 6;
        Assertions.assertEquals(expected, solutionP2495.evenProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 3, 5};
        long expected = 0;
        Assertions.assertEquals(expected, solutionP2495.evenProduct(nums));
    }
}